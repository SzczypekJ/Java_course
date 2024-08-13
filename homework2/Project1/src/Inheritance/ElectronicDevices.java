package Inheritance;

import java.util.Objects;

public abstract class ElectronicDevices {
    protected String device;
    protected int insuranceYears = 2;
    protected int price = 0;
    protected String color;
    protected String brand;

    public ElectronicDevices(String device) {
        this.device = device;
    }

    public ElectronicDevices(String device, int insuranceYears) {
        this.device = device;
        this.insuranceYears = insuranceYears;
    }

    // Abstract method to be implemented by subclasses
    public abstract void calculatePrice();

    public void saySmth() {
        System.out.println("I am an abstract class. Please override me.");
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public int getInsuranceYears() {
        return insuranceYears;
    }

    public void setInsuranceYears(int insuranceYears) {
        this.insuranceYears = insuranceYears;
    }

    public int getPrice() {
        return price;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ElectronicDevices that = (ElectronicDevices) o;
        return insuranceYears == that.insuranceYears &&
                price == that.price &&
                Objects.equals(device, that.device) &&
                Objects.equals(color, that.color) &&
                Objects.equals(brand, that.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(device, insuranceYears, price, color, brand);
    }

    @Override
    public String toString() {
        return "ElectronicDevices{" +
                "device='" + device + '\'' +
                ", insuranceYears=" + insuranceYears +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }

    public abstract void displayDeviceInfo();
}
