package phone.encapsulation;

public class Display {
    private int screenHeight;
    private int screenWidth;

    // Constructor of the PhoneEncapsulation.Display class
    public Display(int screenHeight, int screenWidth) {
        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;
    }

    // Below are setters and getters:
    public int getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    @Override
    public String toString() {
        return "Display{" +
                "screenWidth=" + screenWidth +
                ", screenHeight=" + screenHeight +
                '}';
    }
}
