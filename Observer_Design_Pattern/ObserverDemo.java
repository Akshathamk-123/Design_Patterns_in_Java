package Observer_Design_Pattern;

import java.util.ArrayList;
import java.util.List;

// Observer Interface
interface Observer {
    void update(String message);
}

// Subject Interface
interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// Concrete Subject
class ConcreteSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String state;

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }

    public void setState(String state) {
        this.state = state;
        notifyObservers();
    }

    public String getState() {
        return state;
    }
}

// Concrete Observer
class ConcreteObserver implements Observer {
    private String name;
    private String state;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        this.state = message;
        System.out.println(name + " received update: " + state);
    }
}

// Client Code
public class ObserverDemo {
    public static void main(String[] args) {
        // Create a ConcreteSubject
        ConcreteSubject subject = new ConcreteSubject();

        // Create ConcreteObservers
        Observer observer1 = new ConcreteObserver("Observer1");
        Observer observer2 = new ConcreteObserver("Observer2");

        // Attach observers to the subject
        subject.addObserver(observer1);
        subject.addObserver(observer2);

        // Change the state of the subject
        subject.setState("New State 1");

        // Change the state again
        subject.setState("New State 2");
    }
}
