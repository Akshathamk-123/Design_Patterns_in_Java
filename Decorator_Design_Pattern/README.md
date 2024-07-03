# Decorator Design Pattern

The Decorator Design Pattern is a structural pattern that allows behavior to be added to individual objects, either statically or dynamically, without affecting the behavior of other objects from the same class. This pattern is useful for extending functionalities of classes in a flexible and reusable way.

## Key Concepts

1. **Component**: The interface or abstract class that defines the common operations for both concrete components and decorators.
2. **Concrete Component**: The class that implements the `Component` interface and defines the basic functionality.
3. **Decorator**: An abstract class or interface that also implements the `Component` interface. It maintains a reference to a `Component` object and delegates the basic operations to it.
4. **Concrete Decorators**: Classes that extend the `Decorator` class and add additional behavior to the component.

## Implementation

### Example in Java

#### Component Interface

```java
public interface Coffee {
    String getDescription();
    double cost();
}
```

#### Concrete Component

```java
public class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Simple Coffee";
    }

    @Override
    public double cost() {
        return 5.0;
    }
}
```

#### Decorator Abstract Class

```java
public abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee decoratedCoffee) {
        this.decoratedCoffee = decoratedCoffee;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    @Override
    public double cost() {
        return decoratedCoffee.cost();
    }
}
```

#### Concrete Decorators

```java
public class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Milk";
    }

    @Override
    public double cost() {
        return decoratedCoffee.cost() + 1.0;
    }
}

public class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Sugar";
    }

    @Override
    public double cost() {
        return decoratedCoffee.cost() + 0.5;
    }
}
```

#### Client

```java
public class DecoratorDemo {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + " $" + coffee.cost());

        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription() + " $" + coffee.cost());

        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.getDescription() + " $" + coffee.cost());
    }
}
```

## Advantages

- **Flexible Object Composition**: Allows adding functionalities to objects dynamically without modifying their code.
- **Single Responsibility Principle**: Decorators provide additional functionality while keeping the core class simple and focused.
- **Open/Closed Principle**: The core component is open for extension but closed for modification, allowing new functionalities to be added through decorators.

## Disadvantages

- **Complexity**: Adding multiple decorators can make the system complex and harder to understand.
- **Difficulty in Configuration**: Managing and configuring multiple decorators can be cumbersome.

## Common Use Cases

- **UI Frameworks**: Used in graphical user interfaces to add functionalities such as borders, scroll bars, or shadows to UI components.
- **File I/O Systems**: Extending the capabilities of file input and output streams with additional features such as buffering or data compression.
- **Web Development**: Applying cross-cutting concerns such as logging, authentication, and caching to web components.

## Conclusion

The Decorator Design Pattern is a versatile pattern that provides a flexible way to extend the functionality of objects without altering their structure. By using decorators, you can add responsibilities to objects dynamically, adhering to principles like Single Responsibility and Open/Closed Principle. However, it can introduce complexity and challenges in configuration, which should be carefully managed.

