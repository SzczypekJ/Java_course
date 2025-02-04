package com.solvd.jackson;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE)
public class Car {

    @JsonProperty("Producent")
    private String Producent;

    @JsonProperty("Model")
    private String Model;

    @JsonProperty("Year")
    private Integer Year;

    @JsonProperty("PurchaseDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date PurchaseDate;

    public String getProducent() {
        return Producent;
    }

    public void setProducent(String producent) {
        Producent = producent;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public Integer getYear() {
        return Year;
    }

    public void setYear(Integer year) {
        Year = year;
    }

    public Date getPurchaseDate() {
        return PurchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        PurchaseDate = purchaseDate;
    }

    @Override
    public String toString() {
        return "Car{" +
                "Producent='" + Producent + '\'' +
                ", Model='" + Model + '\'' +
                ", Year=" + Year +
                ", PurchaseDate=" + PurchaseDate +
                '}';
    }

    public Car(String producent, String model, Integer year, Date purchaseDate) {
        Producent = producent;
        Model = model;
        Year = year;
        PurchaseDate = purchaseDate;
    }

    public Car() {
    }
}
