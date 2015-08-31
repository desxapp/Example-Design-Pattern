import designpattern.creational.*;
import designpattern.structural.*;
import designpattern.behavioral.*;
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
		
		patternList.add(new ChainOfResponsibility());
		patternList.add(new Command());
		patternList.add(new Iterator_());
		// patternList.add(new Strategy()); // Need client to test.
		patternList.add(new TemplateMethod());
		patternList.add(new Observer_());
		patternList.add(new Mediator());
		patternList.add(new State());
		patternList.add(new Memento());
		patternList.add(new Visitor());
		// patternList.add(new Interpreter()); // Need a sample.txt file
		
		// Test all patterns via the interface of BasedPattern.
		for (BasedPattern pattern : patternList) {
			pattern.TestPattern();
		}
	}
}