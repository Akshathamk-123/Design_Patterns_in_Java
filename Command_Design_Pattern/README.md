# Command Design Pattern

The Command Design Pattern is a behavioral design pattern that encapsulates a request as an object, thereby allowing for parameterization of clients with different requests, queuing of requests, and logging of the requests. It also provides support for undoable operations. The pattern separates the request for an action from the execution of the action, promoting decoupling between objects that send requests and objects that receive and execute those requests.

## Key Concepts

1. **Command**: An interface or abstract class that declares a method for executing a command.
2. **Concrete Command**: Implements the Command interface and defines the binding between a receiver object and an action.
3. **Receiver**: The object that knows how to perform the operations to satisfy a request.
4. **Invoker**: The object that calls the command to execute the request.
5. **Client**: The object that creates a ConcreteCommand object and sets its receiver.

## Implementation

### Example in Java

#### Command Interface

```java
public interface Command {
    void execute();
}
```

#### Receiver Class

```java
public class Light {
    public void turnOn() {
        System.out.println("Light is ON");
    }

    public void turnOff() {
        System.out.println("Light is OFF");
    }
}
```

#### Concrete Command Classes

```java
public class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

public class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}
```

#### Invoker Class

```java
public class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}
```

#### Client Class

```java
public class CommandDemo {
    public static void main(String[] args) {
        Light livingRoomLight = new Light();
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        RemoteControl remote = new RemoteControl();

        // Turn on the light
        remote.setCommand(lightOn);
        remote.pressButton();

        // Turn off the light
        remote.setCommand(lightOff);
        remote.pressButton();
    }
}
```

## Advantages

- **Decoupling**: Separates the object that invokes the operation from the one that knows how to perform it.
- **Flexibility**: Allows for parameterization of objects with operations, queuing of requests, and logging of operations.
- **Undo Capability**: Can support undoable operations by keeping track of the commands.

## Disadvantages

- **Complexity**: May introduce a large number of classes if many commands are required.
- **Overhead**: Can add additional complexity to the system, making it harder to understand and maintain.

## Common Use Cases

- **GUI Frameworks**: Used in graphical user interface frameworks to implement buttons, menus, and other controls.
- **Transactional Systems**: Useful in systems where commands need to be executed in a specific order and possibly undone.
- **Queueing and Scheduling**: Allows for command queuing and scheduling of operations.

## Conclusion

The Command Design Pattern is a versatile pattern that encapsulates a request as an object, allowing for flexible and decoupled command execution. It supports undoable operations, logging, and queuing of commands. While it introduces additional complexity into the system, its benefits in terms of flexibility and decoupling often outweigh the drawbacks in scenarios requiring command management.
