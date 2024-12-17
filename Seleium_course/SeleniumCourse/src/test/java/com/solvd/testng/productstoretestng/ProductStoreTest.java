package com.solvd.testng.productstoretestng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.time.LocalDate;

public class ProductStoreTest {

    private WebDriver driver;
    private WebDriverWait wait;

    private String price;
    private String productName;

    @BeforeClass
    public void setup() {
        // Configuration of the Webdriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test(priority = 1, description = "Verify user login functionality")
    public void testUserLogin() throws InterruptedException {
        driver.get("https://www.demoblaze.com/index.html");
        Thread.sleep(2000);

        // Click on login button
        driver.findElement(By.xpath("//a[@id='login2']")).click();
        Thread.sleep(2000);

        // Logging data
        String username = "jakubszczypek";
        String password = "1234";

        driver.findElement(By.xpath("//input[@id='loginusername']")).sendKeys(username);
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id='loginpassword']")).sendKeys(password);
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@onclick='logIn()']")).click();
        Thread.sleep(2000);

        // Checking the greeting message
        String actualWelcomeText = driver.findElement(By.xpath("//a[@id='nameofuser']")).getText();
        String expectedWelcomeText = "Welcome " + username;

        Assert.assertEquals(actualWelcomeText, expectedWelcomeText, "The welcome message is not correct");
    }

    @Test(priority = 2, description = "Verify adding a product to the cart")
    public void testAddProductToCart() throws InterruptedException {

        // Click on the product which you choose
        WebElement nexus = driver.findElement(By.xpath("//a[@href='prod.html?idp_=3' and @class='hrefch']"));
        productName = nexus.getText();
        nexus.click();
        Thread.sleep(2000);

        // Get the price of the product
        String rawPrice = driver.findElement(By.xpath("//h3[@class='price-container']")).getText();
        price = rawPrice.replaceAll("[^0-9]", "");
        System.out.println("Cena produktu: " + price);


        // Add product to the cart
        driver.findElement(By.xpath("//a[@onclick='addToCart(3)']")).click();
        Thread.sleep(2000);

        // Handling the allert
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert text: " + alert.getText());
        alert.accept();
        Thread.sleep(2000);

        // Go to the cart page
        driver.findElement(By.xpath("//a[@id='cartur']")).click();
        Thread.sleep(2000);

        // Checking the name and price of the product
        String nameOnPage = driver.findElement(By.cssSelector("#tbodyid > tr > td:nth-child(2)")).getText();
        String priceOnPage = driver.findElement(By.cssSelector("#tbodyid > tr > td:nth-child(3)")).getText();

        Assert.assertEquals(nameOnPage, productName, "Product name mismatch!");
        Assert.assertTrue(price.contains(priceOnPage), "Product price mismatch!");
    }

    @Test(priority = 3, description = "Verify purchasing a product")
    public void testPurchaseProduct() throws InterruptedException {
        // Click on the Order button
        driver.findElement(By.xpath("//button[@data-target='#orderModal']")).click();
        Thread.sleep(2000);

        // Providing the data
        String name = "Jakub";
        String country = "Poland";
        String city = "Cracow";
        String creditCard = "4111111111111111";
        LocalDate today = LocalDate.now();
        // String date = today.getDayOfMonth() + "/" + today.getMonthValue() + "/" + today.getYear();

        driver.findElement(By.xpath("//input[@id='name']")).sendKeys(name);
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='country']")).sendKeys(country);
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='city']")).sendKeys(city);
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='card']")).sendKeys(creditCard);
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='month']")).sendKeys(today.getMonth().toString());
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='year']")).sendKeys(String.valueOf(today.getYear()));
        Thread.sleep(2000);

        // Click on the Purchase button
        driver.findElement(By.xpath("//button[@onclick='purchaseOrder()']")).click();
        Thread.sleep(2000);

        // Get the details from summary
        String purchaseDetails = driver.findElement(By.cssSelector("p.lead.text-muted")).getText();

        Assert.assertTrue(purchaseDetails.contains("Id:"), "Missing ID in purchase details!");
        Assert.assertTrue(purchaseDetails.contains("Amount: " + price), "Amount mismatch!");
        Assert.assertTrue(purchaseDetails.contains("Card Number: " + creditCard), "Card number mismatch!");
        Assert.assertTrue(purchaseDetails.contains("Name: " + name), "Name mismatch!");
        // Assert.assertTrue(purchaseDetails.contains("Date: " + date), "Date mismatch!");

        System.out.println("Test passed: All purchase details are correct!");

        // Closing the confirmation
        driver.findElement(By.xpath("//button[@class='confirm btn btn-lg btn-primary']")).click();
        Thread.sleep(2000);
    }

    @AfterClass
    public void tearDown() {
        // Closing the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
