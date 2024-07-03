package Prototype_Design_Pattern;


// Prototype Interface
interface Prototype {
    Prototype clone();
}

// ConcretePrototype Class
class ConcretePrototype implements Prototype {
    private String field;

    public ConcretePrototype(String field) {
        this.field = field;
    }

    // Getter and Setter for field
    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public Prototype clone() {
        return new ConcretePrototype(this.field);
    }

    @Override
    public String toString() {
        return "ConcretePrototype [field=" + field + "]";
    }
}

// Client Class to Demonstrate Prototype Pattern
public class PrototypeDemo {
    public static void main(String[] args) {
        // Create an original instance of ConcretePrototype
        ConcretePrototype original = new ConcretePrototype("Original");
        System.out.println("Original: " + original);

        // Clone the original instance
        ConcretePrototype clone = (ConcretePrototype) original.clone();
        System.out.println("Clone: " + clone);

        // Modify the cloned instance
        clone.setField("Modified Clone");
        System.out.println("Modified Clone: " + clone);

        // Show that the original instance remains unchanged
        System.out.println("Original after modification: " + original);
    }
}
