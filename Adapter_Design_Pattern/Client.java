package Adapter_Design_Pattern;


// Target Interface
interface Target {
    void request();
}

// Adaptee Class
class Adaptee {
    public void specificRequest() {
        System.out.println("Specific request from Adaptee");
    }
}

// Adapter Class
class Adapter implements Target {
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}

// Client Class
public class Client {
    private Target target;

    public Client(Target target) {
        this.target = target;
    }

    public void makeRequest() {
        target.request();
    }

    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Target adapter = new Adapter(adaptee);
        Client client = new Client(adapter);
        client.makeRequest();
    }
}


