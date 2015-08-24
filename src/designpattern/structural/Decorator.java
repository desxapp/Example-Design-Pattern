package designpattern.structural;

import designpattern.util.BasedPattern;

public class Decorator implements BasedPattern {
	@Override
	public void TestPattern() {
	   Meal meal = new SideDishOne(new FriedChicken());
       System.out.println("Slected: " + meal.getContent());
       System.out.println("Price: " + meal.price());
	}
	interface Meal {
		String getContent();

		double price();
	}

	class FriedChicken implements Meal {
		public String getContent() {
			return "FriedChicken";
		}

		public double price() {
			return 49.0;
		}
	}

	class Hamburger implements Meal {
		public String getContent() {
			return "Hamburger";
		}

		public double price() {
			return 99.0;
		}
	}

	abstract class SideDish implements Meal {
		protected Meal meal;

		SideDish(Meal meal) {
			this.meal = meal;
		}

	}

	class SideDishOne extends SideDish {
		SideDishOne(Meal meal) {
			super(meal);
		}

		public String getContent() {
			return meal.getContent() + "Coke.";
		}

		public double price() {
			return meal.price() + 20;
		}
	}
}
