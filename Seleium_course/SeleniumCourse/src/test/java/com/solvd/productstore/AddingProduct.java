package com.solvd.productstore;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class AddingProduct {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Opening the website
        driver.get("https://www.demoblaze.com/index.html");
        Thread.sleep(2000);

        // Click on some product
        WebElement nexus = driver.findElement(By.xpath("//a[@href='prod.html?idp_=3' and @class='hrefch']"));
        // Get product name
        String nameOfProduct = nexus.getText();
        nexus.click();
        Thread.sleep(2000);

        // Getting the price of the product
        String price = driver.findElement(By.xpath("//h3[@class='price-container']")).getText();

        // Click on Add to cart
        driver.findElement(By.xpath("//a[@onclick='addToCart(3)']")).click();
        Thread.sleep(2000);

        // Handle the alert
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert text: " + alert.getText());
        alert.accept(); // Click OK on the alert
        Thread.sleep(2000);

        // Go to the cart page
        driver.findElement(By.xpath("//a[@id='cartur']")).click();
        Thread.sleep(2000);

        String nameOnPage = driver.findElement(By.cssSelector("#tbodyid > tr > td:nth-child(2)")).getText();
        String priceOnPage = driver.findElement(By.cssSelector("#tbodyid > tr > td:nth-child(3)")).getText();

        // Assert product name
        assert nameOfProduct.equals(nameOnPage) : "Product name mismatch! Expected: " + nameOfProduct + ", but got: " + nameOnPage;

        // Assert product price
        assert price.contains(priceOnPage) : "Product price mismatch! Expected to contain: " + priceOnPage + ", but got: " + price;

        System.out.println("Test passed: Product name and price are correct in the cart.");


        driver.close();

    }
}
