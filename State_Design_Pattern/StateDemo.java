package State_Design_Pattern;


// State Interface
interface State {
    void handleRequest(Context context);
}

// Concrete State A
class ConcreteStateA implements State {
    @Override
    public void handleRequest(Context context) {
        System.out.println("Handling request in ConcreteStateA");
        context.setState(new ConcreteStateB()); // Transition to ConcreteStateB
    }
}

// Concrete State B
class ConcreteStateB implements State {
    @Override
    public void handleRequest(Context context) {
        System.out.println("Handling request in ConcreteStateB");
        context.setState(new ConcreteStateA()); // Transition to ConcreteStateA
    }
}

// Context
class Context {
    private State state;

    public Context(State state) {
        this.state = state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void request() {
        state.handleRequest(this);
    }
}

// Main Class to Demonstrate State Pattern
public class StateDemo {
    public static void main(String[] args) {
        // Create initial state
        State initialState = new ConcreteStateA();
        // Create context with the initial state
        Context context = new Context(initialState);

        // Perform requests
        context.request(); // Handling request in ConcreteStateA
        context.request(); // Handling request in ConcreteStateB
        context.request(); // Handling request in ConcreteStateA
    }
}

