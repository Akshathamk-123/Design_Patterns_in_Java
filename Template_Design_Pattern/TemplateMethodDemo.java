package Template_Design_Pattern;


// Abstract Class
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
    
    // Common step implementation
    private void step3() {
        System.out.println("Step 3: Common step implementation");
    }
}

// Concrete Subclass 1
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

// Concrete Subclass 2
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

// Client
public class TemplateMethodDemo {
    public static void main(String[] args) {
        // Test ConcreteClass1
        AbstractClass obj1 = new ConcreteClass1();
        System.out.println("Executing Template Method for ConcreteClass1:");
        obj1.templateMethod();
        
        System.out.println();
        
        // Test ConcreteClass2
        AbstractClass obj2 = new ConcreteClass2();
        System.out.println("Executing Template Method for ConcreteClass2:");
        obj2.templateMethod();
    }
}
