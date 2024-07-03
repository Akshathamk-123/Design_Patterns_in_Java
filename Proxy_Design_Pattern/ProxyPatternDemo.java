package Proxy_Design_Pattern;



// Subject interface
interface Subject {
    void request();
}

// RealObject class implementing the Subject interface
class RealObject implements Subject {
    @Override
    public void request() {
        System.out.println("RealObject: Handling request");
    }
}

// Proxy class implementing the Subject interface
class Proxy implements Subject {
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

// Client class to demonstrate Proxy Design Pattern
public class ProxyPatternDemo {
    public static void main(String[] args) {
        // Create a Proxy instance
        Subject proxy = new Proxy();
        
        // Use the Proxy to handle the request
        proxy.request();
    }
}
