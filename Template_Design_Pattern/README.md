# Template Method Design Pattern

The Template Method Design Pattern is a behavioral design pattern that defines the skeleton of an algorithm in a base class but lets subclasses override specific steps of the algorithm without changing its structure. This pattern helps to encapsulate the invariant parts of an algorithm and allow customization of its variable parts.

## Key Concepts

1. **Template Method**: A method defined in the base class that outlines the steps of the algorithm. It may call abstract methods that subclasses must implement.
2. **Abstract Class**: Contains the template method and defines default behavior for the steps of the algorithm. It may include abstract methods that need to be implemented by subclasses.
3. **Concrete Subclasses**: Implement the abstract methods and provide specific behavior for the steps defined in the template method.

## Implementation

### Example in Java

#### Abstract Class

```java
abstract class AbstractClass {
    // Template Method
    public final void templateMethod() {
        step1();
        step2();
        step3();
    }

    // Steps of the algorithm
    protected abstract void step1();
    protected abstract void step2();
    private void step3() {
        System.out.println("Step 3: Common step implementation");
    }
}
```

#### Concrete Subclass 1

```java
class ConcreteClass1 extends AbstractClass {
    @Override
    protected void step1() {
        System.out.println("ConcreteClass1: Implementing Step 1");
    }

    @Override
    protected void step2() {
        System.out.println("ConcreteClass1: Implementing Step 2");
    }
}
```

#### Concrete Subclass 2

```java
class ConcreteClass2 extends AbstractClass {
    @Override
    protected void step1() {
        System.out.println("ConcreteClass2: Implementing Step 1");
    }

    @Override
    protected void step2() {
        System.out.println("ConcreteClass2: Implementing Step 2");
    }
}
```

#### Client

```java
public class TemplateMethodDemo {
    public static void main(String[] args) {
        AbstractClass obj1 = new ConcreteClass1();
        obj1.templateMethod();
        
        AbstractClass obj2 = new ConcreteClass2();
        obj2.templateMethod();
    }
}
```

## Advantages

- **Code Reuse**: Common algorithmic steps are implemented in the base class, allowing subclasses to reuse the code without duplication.
- **Control Over the Algorithm**: The base class controls the algorithm's flow, while subclasses provide specific implementations for certain steps.
- **Flexibility**: Allows subclasses to alter parts of the algorithm while preserving its overall structure.

## Disadvantages

- **Increased Complexity**: Introduces a hierarchy of classes, which can make the system more complex.
- **Inheritance Over Composition**: The pattern relies on inheritance, which may be less flexible compared to composition-based designs.

## Common Use Cases

- **Frameworks**: Often used in frameworks where the framework provides the template method and the application provides implementations for specific steps.
- **Data Processing**: Useful for defining a sequence of steps for data processing tasks, where some steps are common and others vary depending on the specific context.
- **Document Generation**: Helps in generating documents where the overall structure is the same, but specific details change.

## Conclusion

The Template Method Design Pattern is a powerful tool for defining the structure of an algorithm while allowing subclasses to customize specific steps. By encapsulating the invariant parts of an algorithm in a base class and delegating the variable parts to subclasses, it promotes code reuse and maintains control over the overall flow of the algorithm.
