package designpattern.creational;

import java.util.*;

import designpattern.util.BasedPattern;

public class SingletonRegistry implements BasedPattern {
	private static Map<String, Object> registry = new HashMap<String, Object>();

	public SingletonRegistry() {
	}

	public static Object getInstance(String classname) {
		Object singleton = registry.get(classname);

		if (singleton != null) {
			return singleton;
		}

		try {
			singleton = Class.forName(classname).newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		registry.put(classname, singleton);

		return singleton;
	}

	@Override
	public void TestPattern() {
		@SuppressWarnings("unused")
		SingletonRegistry instance1 = (SingletonRegistry) getInstance("designpattern.creational.SingletonRegistry");
		@SuppressWarnings("unused")
		SingletonRegistry instance2 = (SingletonRegistry) getInstance("designpattern.creational.SingletonRegistry");
	}
}