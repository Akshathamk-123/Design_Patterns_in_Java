package Iterator_Design_Pattern;



import java.util.ArrayList;
import java.util.List;

// Iterator Interface
interface Iterator {
    boolean hasNext();
    Object next();
}

// Concrete Iterator
class ConcreteIterator implements Iterator {
    private List<Object> items;
    private int position;

    public ConcreteIterator(List<Object> items) {
        this.items = items;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < items.size();
    }

    @Override
    public Object next() {
        return hasNext() ? items.get(position++) : null;
    }
}

// Aggregate Interface
interface Aggregate {
    Iterator createIterator();
}

// Concrete Aggregate
class ConcreteAggregate implements Aggregate {
    private List<Object> items;

    public ConcreteAggregate() {
        this.items = new ArrayList<>();
    }

    public void addItem(Object item) {
        items.add(item);
    }

    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(items);
    }
}

// Client
public class IteratorDemo {
    public static void main(String[] args) {
        // Create a ConcreteAggregate object
        ConcreteAggregate aggregate = new ConcreteAggregate();
        
        // Add items to the aggregate
        aggregate.addItem("Item 1");
        aggregate.addItem("Item 2");
        aggregate.addItem("Item 3");

        // Create an iterator for the aggregate
        Iterator iterator = aggregate.createIterator();

        // Traverse the collection using the iterator
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
