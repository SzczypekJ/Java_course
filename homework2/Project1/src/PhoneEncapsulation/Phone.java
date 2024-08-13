package PhoneEncapsulation;

public class Phone {
    private String model;

    // Create an object of class PhoneEncapsulation.Display
    private Display display;

    // Create an object of class PhoneEncapsulation.NetworkOperator
    private NetworkOperator netOperator;

    private int number;

    // Constructor of the PhoneEncapsulation.Phone class
    public Phone(String model, int number) {
        this.model = model;
        this.number = number;
    }

    // Below are setters and getters:
    public String getModel() {
        return model;
    }

    public int getNumber() {
        return number;
    }

    public Display getDisplay() {
        return display;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public NetworkOperator getNetOperator() {
        return netOperator;
    }

    public void setNetOperator(NetworkOperator netOperator) {
        this.netOperator = netOperator;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "model='" + model + '\'' +
                ", display=" + display +
                ", netOperator=" + netOperator +
                ", number=" + number +
                '}';
    }
}
