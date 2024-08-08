public class Phone {

    String model;

    private Display display;

    private int number;

    public Phone(String model, int number) {
        this.model = model;
        this.number = number;
    }
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
}
