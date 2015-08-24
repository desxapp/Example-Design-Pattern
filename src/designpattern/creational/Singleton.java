package designpattern.creational;

import designpattern.util.BasedPattern;

public class Singleton implements BasedPattern {
	private static Singleton instance = null;

	public Singleton() {
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

	@Override
	public void TestPattern() {
		@SuppressWarnings("unused")
		Singleton instance1 = getInstance();
		@SuppressWarnings("unused")
		Singleton instance2 = getInstance();
	}
}
