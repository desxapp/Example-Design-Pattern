Example-Design-Pattern
======================
A repository for examples of Design Pattern.

Refer to http://openhome.cc/

The sample code information
---------------------------

### (default package)
* /DesignPattern/src/Main.java

	A entry point, test all patterns.

### designpattern.behavioral
* /DesignPattern/src/designpattern/behavioral/ChainOfResponsibility.java]

	Every object Will check the symbol type and push to next object if the type with object does not match.
	
* /DesignPattern/src/designpattern/behavioral/Command.java

	To separation command interface, let the program can execute function of the same nature via a command interface.
	
* /DesignPattern/src/designpattern/behavioral/Interpreter.java

	Parser the command line.
	
* /DesignPattern/src/designpattern/behavioral/Iterator.java

	Make the class can support Iterator to foreach every data.
	
* /DesignPattern/src/designpattern/behavioral/Mediator.java

	A mediator between object and object.
	Refer to http://www.journaldev.com/1730/mediator-design-pattern-in-java-example-tutorial
	
* /DesignPattern/src/designpattern/behavioral/Memento.java

	Backup a status in memory for objects.
	
* /DesignPattern/src/designpattern/behavioral/Observer.java

	Subject can be registration by other observer, and need notify observers when Subject changed.
	
* /DesignPattern/src/designpattern/behavioral/State.java

	Each state become an object, and each state is responsible for its own services.
	
* /DesignPattern/src/designpattern/behavioral/Strategy.java

	Strategy focused on encapsulation of service details or algorithms, user can change algorithm or services, and don't care about the detail.
	
* /DesignPattern/src/designpattern/behavioral/TemplateMethod.java

	Like the Factory Method, but Factory Method is create the object and detail in sub-class, Template Method is implement abstract follow in sub-class.
	
* /DesignPattern/src/designpattern/behavioral/Visitor.java
	
	Separation the algorithm process and object structure and centralized management via interface.

### designpattern.creational
* /DesignPattern/src/designpattern/creational/AbstractFactory.java	

	To define some action for process, but the details will provided by after.

* /DesignPattern/src/designpattern/creational/Builder.java

	A bit like AbstractFactory, but it created object's original nature is the same.

* /DesignPattern/src/designpattern/creational/FactoryMethod.java

	It want the parent class function detail will implementation by the sub-class.

* /DesignPattern/src/designpattern/creational/Prototype.java

	Create a instance once, to save resource by copy a new instance from memory.

* /DesignPattern/src/designpattern/creational/Singleton.java

	Make sure a instance is only one at a runtime.

* /DesignPattern/src/designpattern/creational/SingletonRegistry.java

	To manage more instance at a runtime.

### designpattern.structural
* /DesignPattern/src/designpattern/structural/Adapter.java

	Let different classes can work together via the Adapter.

* /DesignPattern/src/designpattern/structural/Bridge.java

	Make sure to separate the interface(abstract) and implementation(action) and can dynamic binding via a Bridge.
 
* /DesignPattern/src/designpattern/structural/Composite.java

	Make the class is like a tree
 
* /DesignPattern/src/designpattern/structural/Decorator.java

	A class can be used for other class like a plug-in, and it has the same interface.

* /DesignPattern/src/designpattern/structural/Facade.java

	Facade pattern can be simplified using library, and hide library, reducing the coupling of the library.
 
* /DesignPattern/src/designpattern/structural/Flyweight.java

	Save resources through share resources. 
 
* /DesignPattern/src/designpattern/structural/Proxy.java

	Delayed action, the proxy with the real class have identical interface, so it can call the function at time for really needed.

### designpattern.util
* /DesignPattern/src/designpattern/util/BasedPattern.java
	
	A patterns interface for test function.
