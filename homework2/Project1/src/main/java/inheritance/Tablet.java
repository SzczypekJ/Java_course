package inheritance;
import interfaces.*;
import phone.encapsulation.Display;

import java.util.Objects;

public class Tablet extends ElectronicDevices implements Callable, MusicListener, Playable, SocialMediaAccess, Watchable{
    private Display display;

    public Tablet(String device) {
        super(device);
    }

    public Tablet(String device, int insuranceYears) {
        super(device, insuranceYears);
    }

    @Override
    public void calculatePrice() {
        int basePrice = 500;
        if (color != null) {
            switch (color) {
                case "black":
                    basePrice += 500;
                    break;
                case "red":
                    basePrice += 1000;
                    break;
                default:
                    basePrice += 200;
            }
        }
        if (brand != null) {
            switch (brand.toLowerCase()) {
                case "apple":
                    basePrice += 600;
                    break;
                case "samsung":
                    basePrice += 400;
                    break;
                case "lenovo":
                    basePrice += 300;
                    break;
                default:
                    basePrice += 100;
            }
        }
        this.price = basePrice;
    }

    @Override
    public void saySmth() {
        System.out.println("Tablet says: " + this.device + ". I override the abstract class.");
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Tablet tablet = (Tablet) o;
        return Objects.equals(display, tablet.display);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), display);
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "display=" + display +
                ", device='" + device + '\'' +
                ", insuranceYears=" + insuranceYears +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }

    @Override
    public void displayDeviceInfo() {
        System.out.println("Tablet Details: ");
        System.out.println("Device: " + device);
        System.out.println("Color: " + color);
        System.out.println("Brand: " + brand);
        System.out.println("Price: " + price);
        System.out.println("Display: " + (display != null ? display.toString() : "No display set"));
    }

    @Override
    public void callToSomeone() {
        System.out.println("I am Tablet and I can call to someone by Teams");
    }

    @Override
    public void listenMusic() {
        System.out.println("I am Tablet and I can listen the music");
    }

    @Override
    public void playingGames() {
        System.out.println("I am Tablet and I can play games");
    }

    @Override
    public void socialMediaAccess() {
        System.out.println("I am Tablet and I can access social media");
    }

    @Override
    public void watchSmth() {
        System.out.println("I am Tablet and I can watch the movie");
    }

    @Override
    public void tellSmth() {
        System.out.println("I am Tablet and I can listen the music and do a lot of things.");
    }
}
