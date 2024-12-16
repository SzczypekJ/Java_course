package com.solvd.radiobutton;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RadioButton {

    public static String browser = "chrome"; // Możesz zmienić na "firefox" lub "edge".
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        // Wybór przeglądarki z odpowiednimi opcjami
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-notifications"); // Blokowanie alertów powiadomień
                chromeOptions.addArguments("--disable-popup-blocking");
                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addPreference("dom.webnotifications.enabled", false); // Wyłączenie powiadomień
                firefoxOptions.addPreference("dom.disable_beforeunload", true);
                driver = new FirefoxDriver(firefoxOptions);
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--disable-notifications"); // Blokowanie alertów powiadomień
                edgeOptions.addArguments("--disable-popup-blocking");
                driver = new EdgeDriver(edgeOptions);
                break;

            default:
                throw new IllegalArgumentException("Nieobsługiwana przeglądarka: " + browser);
        }

        driver.manage().window().maximize();

        // Otwieranie strony
        driver.get("https://www.singaporeair.com/en_UK/pl/home?gad_source=1&gclid=Cj0KCQiAvP-6BhDyARIsAJ3uv7ZaU5EEx6OC0MkIcRN-7G6MsjIq_hmGFbQPYQLbPRq1m9jsrU-HMCAaApzfEALw_wcB#/book/bookflight");

        // Obsługa ciasteczek
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[@class='dwc--SiaCookie__PopupEssentialBtn dwc--SiaCookie__PopupAllBtn']")
            ));
            acceptCookiesButton.click();
        } catch (Exception e) {
            System.out.println("Nie znaleziono baneru ciasteczek lub już zaakceptowano: " + e.getMessage());
        }

        // Interakcja z radio button
        System.out.println(driver.findElements(By.xpath("//*[@name='book-flight-radio']")).size());

        WebElement radio1 = driver.findElement(By.xpath("//input[@id='bookFlights']"));
        radio1.click();
        System.out.println("Radio1 selected: " + radio1.isSelected());
        Thread.sleep(2000);

        WebElement radio2 = driver.findElement(By.xpath("//input[@id='redeemFlights']"));
        radio2.click();
        System.out.println("Radio2 selected: " + radio2.isSelected());
        Thread.sleep(2000);

        driver.close();
    }
}
