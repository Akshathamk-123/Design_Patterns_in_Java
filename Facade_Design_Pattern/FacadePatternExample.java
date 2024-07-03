package Facade_Design_Pattern;



// Subsystem Class 1
class Subsystem1 {
    public void operation1() {
        System.out.println("Subsystem1: operation1");
    }
}

// Subsystem Class 2
class Subsystem2 {
    public void operation2() {
        System.out.println("Subsystem2: operation2");
    }
}

// Subsystem Class 3
class Subsystem3 {
    public void operation3() {
        System.out.println("Subsystem3: operation3");
    }
}

// Facade
class Facade {
    private Subsystem1 subsystem1;
    private Subsystem2 subsystem2;
    private Subsystem3 subsystem3;

    public Facade() {
        subsystem1 = new Subsystem1();
        subsystem2 = new Subsystem2();
        subsystem3 = new Subsystem3();
    }

    public void simplifiedOperation() {
        System.out.println("Facade: simplifiedOperation");
        subsystem1.operation1();
        subsystem2.operation2();
        subsystem3.operation3();
    }
}

// Client Code
public class FacadePatternExample {
    public static void main(String[] args) {
        // Create a Facade instance
        Facade facade = new Facade();
        
        // Use the Facade to perform a simplified operation
        facade.simplifiedOperation();
    }
}
