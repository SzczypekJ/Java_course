package com.solvd.webdriver.dropdowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AutoSuggestionDropdown {
    public static String browser = "chrome"; // Możesz zmienić na "firefox" lub "edge".
    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {

        // Wybór przeglądarki
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
        }

        driver.manage().window().maximize();

        driver.get("https://www.google.com/travel/flights?gl=PL&hl=en");


        driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div/div/div[2]/div[1]/div[3]/div[1]/div[1]/form[2]/div/div/button/span[6]")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try{
            WebElement search = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//*[@id=\"ow16\"]/div[1]/div/div/input")
            ));
            search.click();
        } catch (Exception e) {
            System.out.println("Nie znaleziono search" + e.getMessage());
        }
        Thread.sleep(2000);

        WebElement from = driver.findElement(By.xpath("//*[@id=\"i23\"]/div[6]/div[2]/div[2]/div[1]/div/input"));

        from.sendKeys("Sydney");
        Thread.sleep(2000);

        from.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);

        from.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        driver.close();
    }

}
