package com.solvd.jaxb;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;

@XmlType(propOrder = {"producent", "model", "year", "purchaseDate"})
public class Car {
    private String producent;
    private String model;
    private String year;

    @XmlTransient
    private Date purchaseDate;

    public Car(String producent, String model, String year, Date purchaseDate) {
        this.producent = producent;
        this.model = model;
        this.year = year;
        this.purchaseDate = purchaseDate;
    }

    public Car() {
    }

    @XmlElement(name = "Producent")
    public String getProducent() {
        return producent;
    }

    public void setProducent(String producent) {
        this.producent = producent;
    }

    @XmlElement(name = "Model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @XmlElement(name = "Year")
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @XmlElement(name = "PurchaseDate")
    @XmlJavaTypeAdapter(DateAdapter.class)
    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getFormattedPurchaseDate() {
        if (purchaseDate == null) {
            return "Unknown";
        }
        return new SimpleDateFormat("dd-MM-yyyy").format(purchaseDate);
    }

    @Override
    public String toString() {
        return "Car{" +
                "producent='" + producent + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", purchaseDate=" + purchaseDate +
                '}';
    }
}
