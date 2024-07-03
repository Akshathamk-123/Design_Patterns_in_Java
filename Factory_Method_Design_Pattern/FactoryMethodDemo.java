package Factory_Method_Design_Pattern;

// Interface for Product
interface Product {
    void use();
}

// ConcreteProductA implements Product
class ConcreteProductA implements Product {
    @Override
    public void use() {
        System.out.println("Using ConcreteProductA");
    }
}

// ConcreteProductB implements Product
class ConcreteProductB implements Product {
    @Override
    public void use() {
        System.out.println("Using ConcreteProductB");
    }
}

// Abstract Creator class
abstract class Creator {
    public abstract Product factoryMethod();

    public void someOperation() {
        // Call the factory method to create a Product object
        Product product = factoryMethod();
        // Use the product
        product.use();
    }
}

// ConcreteCreatorA extends Creator
class ConcreteCreatorA extends Creator {
    @Override
    public Product factoryMethod() {
        return new ConcreteProductA();
    }
}

// ConcreteCreatorB extends Creator
class ConcreteCreatorB extends Creator {
    @Override
    public Product factoryMethod() {
        return new ConcreteProductB();
    }
}

// Main class to demonstrate Factory Method Pattern
public class FactoryMethodDemo {
    public static void main(String[] args) {
        // Test ConcreteCreatorA
        Creator creatorA = new ConcreteCreatorA();
        creatorA.someOperation();

        // Test ConcreteCreatorB
        Creator creatorB = new ConcreteCreatorB();
        creatorB.someOperation();
    }
}
