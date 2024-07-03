package Composite_Design_Pattern;
// Composite class
import java.util.ArrayList;
import java.util.List;

// Component interface
interface Component {
    void operation();
}

// Leaf class
class Leaf implements Component {
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println("Leaf " + name + " operation");
    }
}



class Composite implements Component {
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

// Main class to demonstrate the Composite Design Pattern
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
