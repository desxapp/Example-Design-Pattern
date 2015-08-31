package designpattern.behavioral;

import designpattern.util.BasedPattern;

public class State implements BasedPattern {
	@Override
	public void TestPattern() {
		TrafficLight trafficLight = new TrafficLight();
		for (int i = 0; i < 5; i++)
			trafficLight.change();
	}

	class TrafficLight {
		private IState current = new Red();

		void set(IState state) {
			this.current = state;
		}

		void change() {
			current.change(this);
		}
	}

	interface IState {
		void change(TrafficLight light);
	}

	abstract class Light implements IState {
		public abstract void change(TrafficLight light);

		protected void sleep(int second) {
			try {
				Thread.sleep(second);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	class Red extends Light {
		public void change(TrafficLight light) {
			System.out.println("Red light");
			sleep(1000);
			light.set(new Green());
		}
	}

	class Green extends Light {
		public void change(TrafficLight light) {
			System.out.println("Green light");
			sleep(2000);
			light.set(new Yellow());
		}
	}

	class Yellow extends Light {
		public void change(TrafficLight light) {
			System.out.println("Yellow light");
			sleep(500);
			light.set(new Red());
		}
	}
}
