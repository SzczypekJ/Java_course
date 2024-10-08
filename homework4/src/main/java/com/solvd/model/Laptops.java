package com.solvd.model;
import java.time.LocalDateTime;

public class Laptops {
    private String brand;
    private String model;
    private LocalDateTime now = LocalDateTime.now();
    private int studentId;

    public Laptops(String brand, String model, LocalDateTime now, int studentId) {
        this.brand = brand;
        this.model = model;
        this.now = now;
        this.studentId = studentId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDateTime getNow() {
        return now;
    }

    public void setNow(LocalDateTime now) {
        this.now = now;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Laptops{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", now=" + now +
                ", studentId=" + studentId +
                '}';
    }
}
