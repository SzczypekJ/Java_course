package com.solvd.productstore;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;

public class PurchaseProduct {
    public static void main(String[] args) throws InterruptedException {
        // Reading the logic from the AddingProduct to reuse the code
        AddingProduct.main(args);

        // Using earlier driver from AddingProduct class and click on the Place Order button
        AddingProduct.driver.findElement(By.xpath("//button[@data-target='#orderModal']")).click();
        Thread.sleep(2000);

        // Filling Name field
        String name = "Jakub";
        WebDriverWait wait = new WebDriverWait(AddingProduct.driver, Duration.ofSeconds(10)); // Czekaj maksymalnie 10 sekund
        WebElement nameField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='name']")));
        nameField.sendKeys(name);
        Thread.sleep(2000);

        // Filling Country field
        String country = "Poland";
        AddingProduct.driver.findElement(By.xpath("//input[@id='country']")).sendKeys(country);
        Thread.sleep(2000);

        // Filling City field
        String city = "Cracow";
        AddingProduct.driver.findElement(By.xpath("//input[@id='city']")).sendKeys(city);
        Thread.sleep(2000);

        // Filling Credit Card field
        String creditCard = "4111111111111111";
        AddingProduct.driver.findElement(By.xpath("//input[@id='card']")).sendKeys(creditCard);
        Thread.sleep(2000);

        // Filling Month field
        LocalDate today = LocalDate.now();
        String date = today.getDayOfMonth() + "/" + today.getMonthValue() + "/" + today.getYear();
        String monthName = today.getMonth().toString();

        AddingProduct.driver.findElement(By.xpath("//input[@id='month']")).sendKeys(monthName);
        Thread.sleep(2000);

        int year = today.getYear();
        AddingProduct.driver.findElement(By.xpath("//input[@id='year']")).sendKeys(Integer.toString(year));
        Thread.sleep(2000);

        // Click on the Purchase button
        AddingProduct.driver.findElement(By.xpath("//button[@onclick='purchaseOrder()']")).click();
        Thread.sleep(2000);

        // Getting data from the summary
        String purchaseDetails = AddingProduct.driver.findElement(By.cssSelector("p.lead.text-muted")).getText();

        assert purchaseDetails.contains("Id:") : "Missing ID in purchase details!";
        assert purchaseDetails.contains("Amount: " + AddingProduct.price) : "Amount mismatch!";
        assert purchaseDetails.contains("Card Number: " + creditCard) : "Card Number mismatch!";
        assert purchaseDetails.contains("Name: " + name) : "Name mismatch!";
        assert purchaseDetails.contains("Date: " + date) : "Date mismatch!";

        System.out.println("Test passed: All details are correct!");

        AddingProduct.driver.findElement(By.xpath("//button[@class='confirm btn btn-lg btn-primary']")).click();
        Thread.sleep(2000);

        AddingProduct.driver.quit();

    }
}
