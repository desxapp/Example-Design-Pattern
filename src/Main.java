import designpattern.creational.*;
import designpattern.structural.*;
import designpattern.util.BasedPattern;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		// Add all patterns to pattern list.
		List<BasedPattern> patternList = new ArrayList<BasedPattern>();

		patternList.add(new AbstractFactory());
		patternList.add(new FactoryMethod());
		patternList.add(new Builder());
		patternList.add(new Prototype());
		patternList.add(new Singleton());
		patternList.add(new SingletonRegistry());
		patternList.add(new Adapter());
		patternList.add(new Bridge());
		patternList.add(new Composite());
		patternList.add(new Decorator());
		patternList.add(new Facade());
		patternList.add(new Flyweight());
		patternList.add(new Proxy());
		
		// Test all patterns via the interface of BasedPattern.
		for (BasedPattern pattern : patternList) {
			pattern.TestPattern();
		}
	}
}