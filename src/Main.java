import designpattern.creational.*;

public class Main {
	public static void main(String[] args) {
		// Run test abstract factory, and including simple factory.
		AbstractFactory.Test_AbstractFactory();

		// Run test factory method.
		FactoryMethod.Test_FactoryMethod();

		// Run test Builder.
		Builder.Test_Builder();

		// Run test Singleton.
		Singleton.Test_Singleton();

		// Run test Test_SingletonRegistry.
		SingletonRegistry.Test_SingletonRegistry();
	}
}