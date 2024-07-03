# Flyweight Design Pattern

The Flyweight Design Pattern is a structural design pattern that aims to reduce the number of objects created, to decrease memory usage, and to improve performance. It achieves this by sharing objects that are similar in some way, rather than creating new instances for each object. This pattern is particularly useful when a large number of objects need to be created, and many of them share common attributes.

## Key Concepts

1. **Flyweight**: An interface or abstract class that defines methods for interacting with flyweight objects. Flyweights are objects that can be shared among multiple contexts.
2. **Concrete Flyweight**: Implements the Flyweight interface and represents the shared, intrinsic state of the object.
3. **Flyweight Factory**: A factory class that manages the creation and reuse of flyweight objects. It ensures that flyweights are shared correctly and manages the intrinsic state.
4. **Client**: Uses the Flyweight objects, typically by requesting them from the Flyweight Factory and providing extrinsic state.

## Implementation

### Example in Java

#### Flyweight Interface

```java
// Flyweight Interface
interface Flyweight {
    void operation(String extrinsicState);
}
```

#### Concrete Flyweight

```java
// Concrete Flyweight
class ConcreteFlyweight implements Flyweight {
    private String intrinsicState;

    public ConcreteFlyweight(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    @Override
    public void operation(String extrinsicState) {
        System.out.println("Intrinsic State: " + intrinsicState + ", Extrinsic State: " + extrinsicState);
    }
}
```

#### Flyweight Factory

```java
import java.util.HashMap;
import java.util.Map;

// Flyweight Factory
class FlyweightFactory {
    private Map<String, Flyweight> flyweights = new HashMap<>();

    public Flyweight getFlyweight(String intrinsicState) {
        if (!flyweights.containsKey(intrinsicState)) {
            flyweights.put(intrinsicState, new ConcreteFlyweight(intrinsicState));
        }
        return flyweights.get(intrinsicState);
    }

    public int getFlyweightCount() {
        return flyweights.size();
    }
}
```

#### Client

```java
public class FlyweightPatternDemo {
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();

        Flyweight flyweight1 = factory.getFlyweight("State1");
        Flyweight flyweight2 = factory.getFlyweight("State2");
        Flyweight flyweight3 = factory.getFlyweight("State1");

        flyweight1.operation("Context1");
        flyweight2.operation("Context2");
        flyweight3.operation("Context3");

        System.out.println("Flyweight count: " + factory.getFlyweightCount());
    }
}
```

## Explanation

1. **Flyweight Interface**:
   - Defines the method `operation()` that flyweight objects must implement. This method uses both intrinsic and extrinsic state.

2. **Concrete Flyweight**:
   - Implements the `Flyweight` interface and maintains the intrinsic state. The intrinsic state is shared among multiple flyweights, while the extrinsic state is passed as a parameter to the method `operation()`.

3. **Flyweight Factory**:
   - Manages the creation and sharing of flyweights. It maintains a collection of existing flyweights and returns a shared instance if one already exists for a given intrinsic state. This ensures that the number of objects created is minimized.

4. **Client**:
   - Interacts with the Flyweight Factory to get instances of flyweights and invokes operations on them. The client provides the extrinsic state that is used in the operation.

## Advantages

- **Reduced Memory Usage**: By sharing flyweights, the pattern reduces the number of objects created, thus saving memory.
- **Improved Performance**: Sharing objects reduces the overhead associated with object creation and garbage collection.
- **Separation of Intrinsic and Extrinsic State**: Intrinsic state is shared and managed by the flyweight, while extrinsic state is managed by the client.

## Disadvantages

- **Increased Complexity**: The pattern introduces additional classes and complexity in managing the flyweight objects.
- **Intrinsic and Extrinsic State Management**: Properly managing the separation between intrinsic and extrinsic state can be challenging.

## Common Use Cases

- **Text Rendering**: Used in text editors to manage font styles and character objects efficiently.
- **Graphics Rendering**: Used in graphics applications to manage shapes, colors, and textures.
- **Database Connection Pooling**: Used to manage and reuse a limited number of database connections.

## Conclusion

The Flyweight Design Pattern is a useful tool for optimizing memory usage and performance when dealing with a large number of similar objects. By sharing common parts of objects and separating state, it helps in reducing redundancy and improving efficiency. However, it requires careful management of intrinsic and extrinsic state, which can add complexity to the design.

