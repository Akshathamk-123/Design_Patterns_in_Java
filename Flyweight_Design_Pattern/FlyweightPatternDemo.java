package Flyweight_Design_Pattern;

import java.util.HashMap;
import java.util.Map;

// Flyweight Interface
interface Flyweight {
    void operation(String extrinsicState);
}

// Concrete Flyweight
class ConcreteFlyweight implements Flyweight {
    private String intrinsicState;

    public ConcreteFlyweight(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    @Override
    public void operation(String extrinsicState) {
        System.out.println("Intrinsic State: " + intrinsicState + ", Extrinsic State: " + extrinsicState);
    }
}

// Flyweight Factory
class FlyweightFactory {
    private Map<String, Flyweight> flyweights = new HashMap<>();

    public Flyweight getFlyweight(String intrinsicState) {
        if (!flyweights.containsKey(intrinsicState)) {
            flyweights.put(intrinsicState, new ConcreteFlyweight(intrinsicState));
        }
        return flyweights.get(intrinsicState);
    }

    public int getFlyweightCount() {
        return flyweights.size();
    }
}

// Client
public class FlyweightPatternDemo {
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();

        Flyweight flyweight1 = factory.getFlyweight("State1");
        Flyweight flyweight2 = factory.getFlyweight("State2");
        Flyweight flyweight3 = factory.getFlyweight("State1");

        flyweight1.operation("Context1");
        flyweight2.operation("Context2");
        flyweight3.operation("Context3");

        System.out.println("Flyweight count: " + factory.getFlyweightCount());
    }
}
