package inheritance;
import phone.encapsulation.Display;
import interfaces.*;

import java.util.Objects;

public class Computer extends ElectronicDevices implements Callable, MusicListener, Playable, SocialMediaAccess, Watchable{
    private Display display;

    public Computer(String device) {
        super(device);
    }

    @Override
    public void saySmth() {
        System.out.println("Computer says: " + this.device + ". I override the abstract class.");
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
                    basePrice += 1000;
                    break;
                case "dell":
                    basePrice += 800;
                    break;
                case "hp":
                    basePrice += 700;
                    break;
                default:
                    basePrice += 300;
            }
        }
        this.price = basePrice;
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
        Computer computer = (Computer) o;
        return Objects.equals(display, computer.display);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), display);
    }

    @Override
    public String toString() {
        return "Computer{" +
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
        System.out.println("Computer Details: ");
        System.out.println("Device: " + device);
        System.out.println("Color: " + color);
        System.out.println("Brand: " + brand);
        System.out.println("Price: " + price);
        System.out.println("Display: " + (display != null ? display.toString() : "No display set"));
    }

    @Override
    public void callToSomeone() {
        System.out.println("I am a Computer and I can call to someone by Teams");
    }

    @Override
    public void listenMusic() {
        System.out.println("I am Computer and I can listen the music");
    }

    @Override
    public void playingGames() {
        System.out.println("I am Computer and I can play games");
    }

    @Override
    public void socialMediaAccess() {
        System.out.println("I am Computer and I can access social media");
    }

    @Override
    public void watchSmth() {
        System.out.println("I am Computer and I can watch the movie");
    }

    @Override
    public void tellSmth() {
        System.out.println("I am Computer and I can play video games and do a lot of things.");
    }
}
