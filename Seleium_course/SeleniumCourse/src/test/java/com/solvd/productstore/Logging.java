package com.solvd.productstore;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Logging {
    public static void main(String[] args) throws InterruptedException {
        // Creating a webdriver and setting the chrome configuration
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Opening the website
        driver.get("https://www.demoblaze.com/index.html");
        Thread.sleep(2000);

        // Click on the Login button
        driver.findElement(By.xpath("//a[@id='login2']")).click();
        Thread.sleep(2000);

        // Find username field and write a username
        String userName = "jakubszczypek";
        driver.findElement(By.xpath("//input[@id='loginusername']")).sendKeys(userName);
        Thread.sleep(2000);

        // Find password field and write a password
        String password = "1234";
        driver.findElement(By.xpath("//input[@id='loginpassword']")).sendKeys(password);
        Thread.sleep(2000);

        // Click Log in button
        driver.findElement(By.xpath("//button[@onclick='logIn()']")).click();
        Thread.sleep(2000);

        // Check the username of the logged user on the Welcome text
        String loggedUser = driver.findElement(By.xpath("//a[@id='nameofuser']")).getText();

        // Assert the welcome message
        String expectedWelcomeText = "Welcome " + userName;
        assert loggedUser.equals(expectedWelcomeText) : "Test failed! Expected: " + expectedWelcomeText + ", but got: " + loggedUser;

        System.out.println("Test passed: Welcome message is correct.");

        driver.close();

    }
}
