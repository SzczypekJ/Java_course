package com.solvd.webdriver.second;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Locators {

    public static String browser = "chrome"; // Możesz zmienić na "firefox" lub "edge".
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        // Wybór przeglądarki
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                break;
        }

        // Testowanie różnych selektorów bez zamykania przeglądarki za każdym razem
        driver.get("https://www.saucedemo.com");

        // By.id
        driver.findElement(By.id("user-name")).sendKeys("Testing");

        // By.cssSelector
        driver.findElement(By.cssSelector("#user-name")).clear();
        driver.findElement(By.cssSelector("#user-name")).sendKeys("Testing");

        // By.xpath
        driver.findElement(By.xpath("//*[@id=\"user-name\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("Testing");

        // By.className
        driver.findElement(By.className("form_input")).clear();
        driver.findElement(By.className("form_input")).sendKeys("Testing");

        // By.name
        driver.findElement(By.name("user-name")).clear();
        driver.findElement(By.name("user-name")).sendKeys("Testing");

        // By.tagName
        driver.findElement(By.tagName("input")).clear();
        driver.findElement(By.tagName("input")).sendKeys("Testing");

        // Testowanie linku na innej stronie
        driver.get("https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/");
        driver.findElement(By.linkText("About")).click();

        // Zamknięcie przeglądarki na końcu programu
        driver.close();
    }
}