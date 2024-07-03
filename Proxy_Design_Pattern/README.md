
# Proxy Design Pattern

The Proxy Design Pattern is a structural design pattern that provides an object representing another object. A proxy acts as an intermediary or placeholder for another object to control access to it. This pattern is commonly used for implementing access control, lazy initialization, logging, and other functionalities.

## Key Concepts

1. **Proxy**: The interface that both the RealObject and the Proxy implement. The Proxy usually forwards requests to the RealObject but can add additional behavior before or after the request is forwarded.
2. **RealObject**: The actual object that the Proxy represents. This is the object that performs the real operations.
3. **Client**: The entity that interacts with the Proxy and, through it, with the RealObject. The client does not need to be aware of the proxy’s existence.

## Types of Proxies

1. **Virtual Proxy**: Handles the creation of resource-intensive objects to delay their creation until they are needed.
2. **Remote Proxy**: Represents an object that is located on a different address space, such as on a remote server.
3. **Protection Proxy**: Controls access to the RealObject, often for security purposes.

## Implementation

### Example in Java

#### Subject Interface

```java
public interface Subject {
    void request();
}
```

#### RealObject

```java
public class RealObject implements Subject {
    @Override
    public void request() {
        System.out.println("RealObject: Handling request");
    }
}
```

#### Proxy

```java
public class Proxy implements Subject {
    private RealObject realObject;

    @Override
    public void request() {
        if (realObject == null) {
            realObject = new RealObject();
        }
        // Additional behavior can be added here
        System.out.println("Proxy: Delegating request to RealObject");
        realObject.request();
    }
}
```

#### Client

```java
public class ProxyPatternDemo {
    public static void main(String[] args) {
        Subject proxy = new Proxy();
        proxy.request();
    }
}
```

## Advantages

- **Control Access**: Proxies can control access to the RealObject, providing additional functionality such as authentication or logging.
- **Lazy Initialization**: Virtual proxies can delay the creation of resource-intensive objects until they are actually needed.
- **Separation of Concerns**: By using proxies, you can separate the concerns of controlling access to an object from the actual business logic of the RealObject.

## Disadvantages

- **Increased Complexity**: The introduction of proxies adds additional classes and complexity to the system, which can make the code harder to understand.
- **Performance Overhead**: Proxies may introduce some performance overhead due to additional layers of indirection.

## Common Use Cases

- **Security**: Protection proxies are used to provide access control to sensitive operations or data.
- **Remote Method Invocation**: Remote proxies are used in distributed systems to represent objects that are located on remote servers.
- **Resource Management**: Virtual proxies are used to manage the creation of expensive resources, ensuring they are only created when necessary.

## Conclusion

The Proxy Design Pattern is a powerful structural pattern that allows for controlling access to objects and adding additional behavior without altering the object itself. It is particularly useful for implementing access control, lazy initialization, and remote method invocation. However, it can introduce additional complexity and performance overhead, so it should be used judiciously.
