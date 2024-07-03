package Mediator_Design_pattern;


// Mediator Interface
interface Mediator {
    void send(String message, Colleague colleague);
}

// Concrete Mediator
class ConcreteMediator implements Mediator {
    private ConcreteColleague1 colleague1;
    private ConcreteColleague2 colleague2;

    public void setColleague1(ConcreteColleague1 colleague1) {
        this.colleague1 = colleague1;
    }

    public void setColleague2(ConcreteColleague2 colleague2) {
        this.colleague2 = colleague2;
    }

    @Override
    public void send(String message, Colleague colleague) {
        if (colleague == colleague1) {
            colleague2.receive(message);
        } else if (colleague == colleague2) {
            colleague1.receive(message);
        }
    }
}

// Colleague Interface
abstract class Colleague {
    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void receive(String message);
}

// Concrete Colleague 1
class ConcreteColleague1 extends Colleague {
    public ConcreteColleague1(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void receive(String message) {
        System.out.println("ConcreteColleague1 received: " + message);
    }

    public void send(String message) {
        mediator.send(message, this);
    }
}

// Concrete Colleague 2
class ConcreteColleague2 extends Colleague {
    public ConcreteColleague2(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void receive(String message) {
        System.out.println("ConcreteColleague2 received: " + message);
    }

    public void send(String message) {
        mediator.send(message, this);
    }
}

// Main class to demonstrate Mediator Pattern
public class MediatorDemo {
    public static void main(String[] args) {
        // Create the Mediator
        ConcreteMediator mediator = new ConcreteMediator();

        // Create Colleagues and set the Mediator
        ConcreteColleague1 colleague1 = new ConcreteColleague1(mediator);
        ConcreteColleague2 colleague2 = new ConcreteColleague2(mediator);

        mediator.setColleague1(colleague1);
        mediator.setColleague2(colleague2);

        // Test sending messages
        colleague1.send("Hello from Colleague1");
        colleague2.send("Hello from Colleague2");
    }
}
