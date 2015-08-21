package designpattern.creational;

import java.util.*;

public class SingletonRegistry {
	private static Map<String, Object> registry = new HashMap<String, Object>();

	private SingletonRegistry() {
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

	public static void Test_SingletonRegistry() {
		@SuppressWarnings("unused")
		SingletonRegistry instance1 = (SingletonRegistry) getInstance("designpattern.creational.SingletonRegistry");
		@SuppressWarnings("unused")
		SingletonRegistry instance2 = (SingletonRegistry) getInstance("designpattern.creational.SingletonRegistry");
	}
}