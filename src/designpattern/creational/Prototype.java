package designpattern.creational;

import java.util.*;

public class Prototype {
	public static void Test_Prototype() throws CloneNotSupportedException {
		Car bmw = new Car();
		Car benz = new Car();

		Cars cars = new Cars();
		cars.addPrototype("BMW", bmw);
		cars.addPrototype("BENS", benz);

		@SuppressWarnings("unused")
		Car bmwPrototype = cars.getPrototype("BMW");
	}
}

class Wheel implements Cloneable {
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

class Car implements Cloneable {
	private Wheel[] wheels = { new Wheel(), new Wheel(), new Wheel(),
			new Wheel() };

	protected Object clone() throws CloneNotSupportedException {
		Car copy = (Car) super.clone();
		copy.wheels = (Wheel[]) this.wheels.clone();
		
		for (int i = 0; i < this.wheels.length; i++) {
			copy.wheels[i] = (Wheel) this.wheels[i].clone();
		}
		
		return copy;
	}
}

class Cars {
	private Map<String, Car> prototypes = new HashMap<String, Car>();

	void addPrototype(String brand, Car prototype) {
		prototypes.put(brand, prototype);
	}

	Car getPrototype(String brand) throws CloneNotSupportedException {
		return (Car) prototypes.get(brand).clone();
	}
}