# Mediator Design Pattern

The Mediator Design Pattern is a behavioral design pattern that defines an object that encapsulates how a set of objects interact. This pattern promotes loose coupling by keeping objects from referring to each other explicitly, and it allows for easier maintenance and modification of interactions between objects.

## Key Concepts

1. **Mediator**: Defines an interface for communication between Colleague objects. It is responsible for coordinating the interactions between the objects.
2. **Concrete Mediator**: Implements the Mediator interface and coordinates the communication between Colleague objects.
3. **Colleague**: Represents the objects that communicate with each other through the Mediator. They do not communicate directly but interact through the Mediator.
4. **Concrete Colleague**: Implements the Colleague interface and sends/receives requests from the Mediator.

## Implementation

### Example in Java

#### Mediator Interface

```java
public interface Mediator {
    void send(String message, Colleague colleague);
}
```

#### Concrete Mediator

```java
public class ConcreteMediator implements Mediator {
    private ConcreteColleague1 colleague1;
    private ConcreteColleague2 colleague2;

    public void setColleague1(ConcreteColleague1 colleague1) {
        this.colleague1 = colleague1;
    }

    public void setColleague2(ConcreteColleague2 colleague2) {
        this.colleague2 = colleague2;
    }

    @Override
    public void send(String message, Colleague colleague) {
        if (colleague == colleague1) {
            colleague2.receive(message);
        } else if (colleague == colleague2) {
            colleague1.receive(message);
        }
    }
}
```

#### Colleague Interface

```java
public abstract class Colleague {
    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void receive(String message);
}
```

#### Concrete Colleague 1

```java
public class ConcreteColleague1 extends Colleague {
    public ConcreteColleague1(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void receive(String message) {
        System.out.println("ConcreteColleague1 received: " + message);
    }

    public void send(String message) {
        mediator.send(message, this);
    }
}
```

#### Concrete Colleague 2

```java
public class ConcreteColleague2 extends Colleague {
    public ConcreteColleague2(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void receive(String message) {
        System.out.println("ConcreteColleague2 received: " + message);
    }

    public void send(String message) {
        mediator.send(message, this);
    }
}
```

#### Client

```java
public class MediatorDemo {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();

        ConcreteColleague1 colleague1 = new ConcreteColleague1(mediator);
        ConcreteColleague2 colleague2 = new ConcreteColleague2(mediator);

        mediator.setColleague1(colleague1);
        mediator.setColleague2(colleague2);

        colleague1.send("Hello from Colleague1");
        colleague2.send("Hello from Colleague2");
    }
}
```

## Advantages

- **Reduced Coupling**: Promotes loose coupling between Colleagues by centralizing the interaction logic in the Mediator.
- **Improved Maintainability**: Simplifies the modification of interaction logic since changes are localized to the Mediator.
- **Enhanced Flexibility**: Allows for easier management and extension of the communication logic between objects.

## Disadvantages

- **Complexity**: The Mediator can become a central point of complexity, especially if it handles many interactions.
- **Overuse**: Using a Mediator for simple interactions may add unnecessary complexity.

## Common Use Cases

- **User Interface Systems**: Managing interactions between different UI components.
- **Communication Systems**: Coordinating message exchanges between various components of a system.
- **Workflow Systems**: Orchestrating complex workflows where multiple entities need to interact in a coordinated manner.

## Conclusion

The Mediator Design Pattern provides a way to manage interactions between objects in a decoupled manner. By centralizing the communication logic in a Mediator, it simplifies the management of object interactions and improves flexibility and maintainability. However, it should be used judiciously to avoid creating a complex or monolithic Mediator.
