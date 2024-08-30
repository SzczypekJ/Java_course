package phone.encapsulation;

public class NetworkOperator {
    private String networkName;

    // Constructor of the PhoneEncapsulation.NetworkOperator class
    public NetworkOperator(String networkName) {
        this.networkName = networkName;
    }

    // Method that allows us to ask the network operator about something
    public void askSomething(Phone phone) {
        System.out.println("You are talking with " + this.networkName + " operator using the following phone: " + phone.getModel());
    }

    // Below are setters and getters:
    public String getNetworkName() {
        return networkName;
    }

    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }

    // An example of method overriding. By overriding the toString() method,
    // we can customize the string representation of the PhoneEncapsulation.NetworkOperator object
    // to return the name of the network operator instead of the default object representation.
    @Override
    public String toString() {
        return this.networkName;
    }
}
