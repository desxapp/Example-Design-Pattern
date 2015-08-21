package designpattern.creational;

public class Singleton {
	private static Singleton instance = null;

	private Singleton() {
	}

	// Make sure the instance will be only one.
	public static Singleton getInstance() {
		// Double check
		if (instance == null) {
			// Check all thread instance is the same
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}

	public static void Test_Singleton() {
		@SuppressWarnings("unused")
		Singleton instance1 = getInstance();
		@SuppressWarnings("unused")
		Singleton instance2 = getInstance();
	}
}
