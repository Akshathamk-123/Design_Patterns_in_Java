package Stratergy_Design_Pattern;


// Strategy Interface
interface Strategy {
    void execute();
}

// Concrete Strategy A
class ConcreteStrategyA implements Strategy {
    @Override
    public void execute() {
        System.out.println("Executing Strategy A");
    }
}

// Concrete Strategy B
class ConcreteStrategyB implements Strategy {
    @Override
    public void execute() {
        System.out.println("Executing Strategy B");
    }
}

// Context
class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void performOperation() {
        strategy.execute();
    }
}

// Client
public class StrategyDemo {
    public static void main(String[] args) {
        // Create a context with a specific strategy
        Context context = new Context(new ConcreteStrategyA());
        System.out.println("Initial Strategy:");
        context.performOperation();

        // Change the strategy at runtime
        context.setStrategy(new ConcreteStrategyB());
        System.out.println("Changed Strategy:");
        context.performOperation();
    }
}
