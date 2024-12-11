package com.solvd.relativelocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class DemoTest {
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

        // Otwórz stronę "saucedemo"
        driver.get("https://www.saucedemo.com");

        // Znajdź pole tekstowe "Username" znajdujące się powyżej pola "Password"
        WebElement usernameField = driver.findElement(RelativeLocator.with(By.tagName("input")).above(By.id("password")));

        // Wprowadź tekst "Testing" w znalezionym polu
        usernameField.sendKeys("Testing");

        // Dodanie krótkiego opóźnienia w celu obserwacji wyniku (tylko do celów demonstracyjnych)
        Thread.sleep(2000);

        // Zamknięcie przeglądarki
        driver.quit();
    }
}
