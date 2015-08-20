import designpattern.creational.AbstractFactory;
import designpattern.creational.FactoryMethod;

public class Main {
	public static void main(String[] args) {
		// Run test abstract factory, and including simple factory.
		AbstractFactory.Test_AbstractFactory();

		// Run test factory method.
		FactoryMethod.Test_FactoryMethod();
	}
}