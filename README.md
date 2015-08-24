# Example-Design-Pattern
A repository for examples of Design Pattern.

(default package)
/DesignPattern/src/Main.java
# A entry point, test all patterns.

designpattern.creational
/DesignPattern/src/designpattern/creational/AbstractFactory.java
# To define some action for process, but the details will provided by after.

/DesignPattern/src/designpattern/creational/Builder.java
# A bit like AbstractFactory, but it created object's original nature is the same.

/DesignPattern/src/designpattern/creational/FactoryMethod.java
# It want the parent class function detail will implementation by the sub-class.

/DesignPattern/src/designpattern/creational/Prototype.java
# Create a instance once, to save resource by copy a new instance from memory.

/DesignPattern/src/designpattern/creational/Singleton.java
# Make sure a instance is only one at a runtime.

/DesignPattern/src/designpattern/creational/SingletonRegistry.java
# To manage more instance at a runtime.

designpattern.structural
/DesignPattern/src/designpattern/structural/Adapter.java
# Let different classes can work together via the Adapter.

/DesignPattern/src/designpattern/structural/Bridge.java
# Make sure to separate the interface(abstract) and implementation(action) and can dynamic binding via a Bridge.
 
/DesignPattern/src/designpattern/structural/Composite.java
# Make the class is like a tree
 
/DesignPattern/src/designpattern/structural/Decorator.java
# A class can be used for other class like a plug-in, and it has the same interface.

/DesignPattern/src/designpattern/structural/Facade.java
# Facade pattern can be simplified using library, and hide library, reducing the coupling of the library.
 
/DesignPattern/src/designpattern/structural/Flyweight.java
# Save resources through share resources. 
 
/DesignPattern/src/designpattern/structural/Proxy.java
# Delayed action, the proxy with the real class have identical interface, so it can call the function at time for really needed.

designpattern.util
/DesignPattern/src/designpattern/util/BasedPattern.java
# A patterns interface for test function.
