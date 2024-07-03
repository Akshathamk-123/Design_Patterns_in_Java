package Visitor_Design_Pattern;
// Object Structure
import java.util.ArrayList;
import java.util.List;


// Visitor Interface
interface Visitor {
    void visit(ConcreteElementA element);
    void visit(ConcreteElementB element);
}

// Concrete Visitors
class ConcreteVisitor1 implements Visitor {
    @Override
    public void visit(ConcreteElementA element) {
        System.out.println("ConcreteVisitor1 visiting ConcreteElementA");
    }

    @Override
    public void visit(ConcreteElementB element) {
        System.out.println("ConcreteVisitor1 visiting ConcreteElementB");
    }
}

class ConcreteVisitor2 implements Visitor {
    @Override
    public void visit(ConcreteElementA element) {
        System.out.println("ConcreteVisitor2 visiting ConcreteElementA");
    }

    @Override
    public void visit(ConcreteElementB element) {
        System.out.println("ConcreteVisitor2 visiting ConcreteElementB");
    }
}

// Element Interface
interface Element {
    void accept(Visitor visitor);
}

// Concrete Elements
class ConcreteElementA implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class ConcreteElementB implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}



class ObjectStructure {
    private List<Element> elements = new ArrayList<>();

    public void addElement(Element element) {
        elements.add(element);
    }

    public void accept(Visitor visitor) {
        for (Element element : elements) {
            element.accept(visitor);
        }
    }
}

// Client
public class VisitorDemo {
    public static void main(String[] args) {
        ObjectStructure structure = new ObjectStructure();
        structure.addElement(new ConcreteElementA());
        structure.addElement(new ConcreteElementB());

        Visitor visitor1 = new ConcreteVisitor1();
        System.out.println("Applying ConcreteVisitor1:");
        structure.accept(visitor1);

        Visitor visitor2 = new ConcreteVisitor2();
        System.out.println("Applying ConcreteVisitor2:");
        structure.accept(visitor2);
    }
}
