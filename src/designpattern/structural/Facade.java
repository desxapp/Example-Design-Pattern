package designpattern.structural;

import designpattern.util.BasedPattern;

public class Facade implements BasedPattern {
	@Override
	public void TestPattern() {
		Application application = new Application(new ActionService());
		application.doAction();
	}

	interface Service {
		public abstract void doAction();
	}

	// You can to modify methods and doesn't impact interface.
	class ActionService implements Service {
		public void doAction() {
			// Some some = new Some();
			// Other other = new Other();
			// API api = new API();
			System.out.println("Implements action with other APIs.");
		}
	}

	class Application {
		private Service service;

		Application(Service service) {
			this.service = service;
		}

		void doAction() {
			service.doAction();
		}
	}
}
