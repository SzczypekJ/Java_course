public class Phone {
    private String model;

    // Create an object of class Display
    private Display display;

    // Create an object of class NetworkOperator
    private NetworkOperator netOperator;

    private int number;

    // Constructor of the Phone class
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
}
