package inheritance;
import interfaces.*;
import phone.encapsulation.Display;

import java.util.Objects;

// TV cant play video games, have access to social media and call to someone
// so this class dont implements this methods
public class TV extends ElectronicDevices implements MusicListener, Watchable{
    private Display display;

    public TV(String device) {
        super(device);
    }

    @Override
    public void saySmth() {
        System.out.println("TV says: " + this.device + ". I override the abstract class.");
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
                case "samsung":
                    basePrice += 300;
                    break;
                case "lg":
                    basePrice += 200;
                    break;
                case "sony":
                    basePrice += 400;
                    break;
                default:
                    basePrice += 100;
            }
        }
        this.price = basePrice;
    }

    @Override
    public String toString() {
        return "TV{" +
                "display=" + display +
                ", device='" + device + '\'' +
                ", insuranceYears=" + insuranceYears +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", brand='" + brand + '\'' +
                '}';
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
        TV tv = (TV) o;
        return Objects.equals(display, tv.display);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), display);
    }

    @Override
    public void displayDeviceInfo() {
        System.out.println("TV Details: ");
        System.out.println("Device: " + device);
        System.out.println("Color: " + color);
        System.out.println("Brand: " + brand);
        System.out.println("Price: " + price);
        System.out.println("Display: " + (display != null ? display.toString() : "No display set"));
    }

    @Override
    public void listenMusic() {
        System.out.println("I am TV and I can listen the music");
    }

    @Override
    public void watchSmth() {
        System.out.println("I am TV and I can watch some movie");
    }

    @Override
    public void tellSmth() {
        System.out.println("I am TV and I can watch a movie and do a lot of things.");
    }
}
