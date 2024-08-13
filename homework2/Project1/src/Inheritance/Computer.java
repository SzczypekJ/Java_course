package Inheritance;
import PhoneEncapsulation.*;

import java.util.Objects;

public class Computer extends ElectronicDevices {
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

}
