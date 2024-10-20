package com.solvd.JSON;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Phone {
    @JsonProperty("model")
    private String model;

    @JsonProperty("year")
    private int year;

    public Phone(String model, int year) {
        this.model = model;
        this.year = year;
    }

    public Phone() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "model='" + model + '\'' +
                ", year=" + year +
                '}';
    }
}
