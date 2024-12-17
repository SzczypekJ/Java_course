package com.solvd.webdriver.second;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest {

    // Zmienna przechowująca nazwę przeglądarki, którą chcemy uruchomić.
    // Możliwe wartości: "chrome", "firefox", "edge".
    public static String browser = "chrome";

    // Deklaracja WebDrivera - sterownika, który będzie używany do zarządzania przeglądarką.
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        // Instrukcja switch do wyboru przeglądarki na podstawie wartości zmiennej "browser".
        switch (browser) {
            case "chrome":
                // Automatyczna konfiguracja sterownika Chrome za pomocą WebDriverManager.
                WebDriverManager.chromedriver().setup();
                // Tworzenie instancji WebDrivera dla Chrome.
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
            case "firefox":
                // Automatyczna konfiguracja sterownika Firefox za pomocą WebDriverManager.
                WebDriverManager.firefoxdriver().setup();
                // Tworzenie instancji WebDrivera dla Firefox.
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
            case "edge":
                // Automatyczna konfiguracja sterownika Edge za pomocą WebDriverManager.
                WebDriverManager.edgedriver().setup();
                // Tworzenie instancji WebDrivera dla Edge.
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                break;
        }

        // Otwiera stronę "https://www.saucedemo.com" w wybranej przeglądarce.
        driver.get("https://www.saucedemo.com");

        // Znajduje pole tekstowe dla nazwy użytkownika (po ID "user-name") i wprowadza tekst "standard_user".
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        // Znajduje pole tekstowe dla hasła (po ID "password") i wprowadza tekst "secret_sauce".
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        // Znajduje przycisk logowania (po XPath) i klika w niego.
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

        // Wstrzymuje działanie programu na 2 sekundy, aby można było zaobserwować efekt w przeglądarce.
        Thread.sleep(2000);

        // Zamyka okno przeglądarki po zakończeniu testu.
        driver.close();
    }
}