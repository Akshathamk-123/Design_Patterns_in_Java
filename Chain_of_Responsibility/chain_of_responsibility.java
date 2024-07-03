package Chain_of_Responsibility;
// Handler interface
abstract class Handler {
    protected Handler nextHandler;

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handleRequest(String request);
}

// Concrete Handler A
class ConcreteHandlerA extends Handler {
    @Override
    public void handleRequest(String request) {
        if (request.equals("A")) {
            System.out.println("Handler A processing request: " + request);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}

// Concrete Handler B
class ConcreteHandlerB extends Handler {
    @Override
    public void handleRequest(String request) {
        if (request.equals("B")) {
            System.out.println("Handler B processing request: " + request);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}

// Concrete Handler C
class ConcreteHandlerC extends Handler {
    @Override
    public void handleRequest(String request) {
        if (request.equals("C")) {
            System.out.println("Handler C processing request: " + request);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}

// Client code to demonstrate the Chain of Responsibility Pattern
public class chain_of_responsibility {
    public static void main(String[] args) {
        // Create handlers
        Handler handlerA = new ConcreteHandlerA();
        Handler handlerB = new ConcreteHandlerB();
        Handler handlerC = new ConcreteHandlerC();

        // Set up chain of responsibility
        handlerA.setNextHandler(handlerB);
        handlerB.setNextHandler(handlerC);

        // Create a request and pass it through the chain
        String[] requests = {"A", "B", "C", "D"};

        for (String request : requests) {
            System.out.println("Processing request: " + request);
            handlerA.handleRequest(request);
        }
    }
}
