package Builder_Design_Pattern;

// Product class
class Product {
    private String partA;
    private String partB;
    private String partC;

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public void setPartC(String partC) {
        this.partC = partC;
    }

    @Override
    public String toString() {
        return "Product [partA=" + partA + ", partB=" + partB + ", partC=" + partC + "]";
    }
}

// Builder interface
interface Builder {
    void buildPartA();
    void buildPartB();
    void buildPartC();
    Product getResult();
}

// ConcreteBuilder class
class ConcreteBuilder implements Builder {
    private Product product = new Product();

    @Override
    public void buildPartA() {
        product.setPartA("Part A");
    }

    @Override
    public void buildPartB() {
        product.setPartB("Part B");
    }

    @Override
    public void buildPartC() {
        product.setPartC("Part C");
    }

    @Override
    public Product getResult() {
        return product;
    }
}

// Director class
class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct() {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
    }
}

// Client class
public class BuilderPatternDemo {
    public static void main(String[] args) {
        // Create a ConcreteBuilder instance
        Builder builder = new ConcreteBuilder();
        
        // Create a Director instance with the builder
        Director director = new Director(builder);
        
        // Construct the product using the director
        director.construct();
        
        // Retrieve and display the constructed product
        Product product = builder.getResult();
        System.out.println(product);
    }
}
