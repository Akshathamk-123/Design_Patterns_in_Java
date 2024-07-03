# Memento Design Pattern

The Memento Design Pattern is a behavioral design pattern that provides the ability to restore an object's state to a previous state without exposing its internal structure. It allows for saving and restoring the state of an object without exposing its implementation details.

## Key Concepts

1. **Originator**: The object whose state needs to be saved and restored. It creates a memento containing a snapshot of its current state.
2. **Memento**: The object that stores the state of the originator. It provides access to the state without exposing the originator's internal structure.
3. **Caretaker**: The object that is responsible for keeping the memento. It can request the originator to create a memento or restore the state from a memento but does not modify the memento itself.

## Implementation

### Example in Java

#### Memento Class

The Memento class holds the state of the Originator. It is typically private and only accessible by the Originator.

```java
public class Memento {
    private final String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
```

#### Originator Class

The Originator class creates a Memento containing a snapshot of its state and can restore its state from a Memento.

```java
public class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
    }
}
```

#### Caretaker Class

The Caretaker class manages the memento, keeping track of the state history.

```java
import java.util.ArrayList;
import java.util.List;

public class Caretaker {
    private final List<Memento> mementoList = new ArrayList<>();

    public void addMemento(Memento memento) {
        mementoList.add(memento);
    }

    public Memento getMemento(int index) {
        return mementoList.get(index);
    }
}
```

#### Main Class

The main class demonstrates the use of the Memento pattern by saving and restoring the state of the Originator.

```java
public class MementoDemo {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        originator.setState("State #1");
        originator.setState("State #2");
        caretaker.addMemento(originator.saveStateToMemento());

        originator.setState("State #3");
        caretaker.addMemento(originator.saveStateToMemento());

        originator.setState("State #4");

        System.out.println("Current State: " + originator.getState());
        originator.getStateFromMemento(caretaker.getMemento(1));
        System.out.println("Restored State: " + originator.getState());
        originator.getStateFromMemento(caretaker.getMemento(0));
        System.out.println("Restored State: " + originator.getState());
    }
}
```

### Explanation

1. **Memento**: Holds the state of the Originator and provides access to the state.
2. **Originator**: Can create a memento of its current state and restore its state from a memento.
3. **Caretaker**: Manages the mementos and maintains the history of saved states.

### Advantages

- **Encapsulation**: Protects the internal state of the Originator from being modified by external classes.
- **State Management**: Facilitates the implementation of undo/redo functionality and state restoration.

### Disadvantages

- **Memory Consumption**: Storing multiple mementos can consume significant memory if the state data is large.
- **Complexity**: Can add complexity to the system with multiple classes and state management.

### Common Use Cases

- **Undo Mechanism**: Useful in applications with undo functionality, such as text editors or drawing applications.
- **State Restoration**: Ideal for scenarios where objects need to be restored to previous states.

### Conclusion

The Memento Design Pattern is a useful pattern for managing and restoring object states while preserving encapsulation. By keeping the state management separate from the originator, it helps in implementing features like undo functionality and state restoration in a clean and controlled manner.
