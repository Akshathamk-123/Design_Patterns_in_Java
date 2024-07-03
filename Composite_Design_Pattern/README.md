
# Composite Design Pattern

The Composite Design Pattern is a structural pattern that allows you to compose objects into tree-like structures to represent part-whole hierarchies. This pattern treats individual objects and compositions of objects uniformly, enabling clients to work with single objects and compositions of objects in the same way.

## Key Concepts

1. **Component**: An abstract class or interface that defines the common interface for all concrete objects and their compositions. It declares operations that can be performed on leaf and composite objects.
2. **Leaf**: A concrete class that represents end objects in the composition. It implements the `Component` interface and contains no children.
3. **Composite**: A concrete class that represents a node in the tree structure. It implements the `Component` interface and maintains a collection of child components (both `Leaf` and other `Composite` objects). It provides methods to add, remove, and access child components.

## Implementation

### Example in Java

#### Component Interface

```java
// Component
public interface Component {
    void operation();
}
```

#### Leaf Class

```java
// Leaf
public class Leaf implements Component {
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println("Leaf " + name + " operation");
    }
}
```

#### Composite Class

```java
// Composite
import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    private List<Component> children = new ArrayList<>();
    private String name;

    public Composite(String name) {
        this.name = name;
    }

    public void add(Component component) {
        children.add(component);
    }

    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    public void operation() {
        System.out.println("Composite " + name + " operation");
        for (Component child : children) {
            child.operation();
        }
    }
}
```

#### Client

```java
public class CompositePatternDemo {
    public static void main(String[] args) {
        // Create leaf objects
        Component leaf1 = new Leaf("Leaf1");
        Component leaf2 = new Leaf("Leaf2");

        // Create composite objects
        Composite composite1 = new Composite("Composite1");
        Composite composite2 = new Composite("Composite2");

        // Build the hierarchy
        composite1.add(leaf1);
        composite1.add(leaf2);
        composite2.add(composite1);

        // Perform operations
        System.out.println("Composite2 operation:");
        composite2.operation();

        System.out.println("\nComposite1 operation:");
        composite1.operation();
    }
}
```

## Advantages

- **Flexibility**: Clients can treat individual objects and compositions uniformly.
- **Simplicity**: Simplifies the client code by treating complex tree structures and simple objects in the same way.
- **Ease of Maintenance**: Easier to add new components to the hierarchy, as new leaf or composite classes can be added without affecting existing code.

## Disadvantages

- **Complexity**: The pattern can introduce complexity in managing the hierarchy, especially if the structure becomes deep or has many levels.
- **Overhead**: Can introduce overhead due to the additional abstraction and management of child components.

## Common Use Cases

- **File Systems**: Representing directories and files where both directories and files can be treated uniformly.
- **Graphic Systems**: Creating complex graphical elements composed of simpler elements, such as drawing shapes and groups of shapes.
- **UI Frameworks**: Building hierarchical user interface components where individual components and groups of components are managed uniformly.

## Conclusion

The Composite Design Pattern is a powerful structural pattern that allows you to build complex tree structures where clients can work with individual objects and compositions of objects in a uniform manner. It promotes flexibility and simplicity in managing part-whole hierarchies, though it can introduce additional complexity and overhead in managing the structure.

