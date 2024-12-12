package com.solvd.links;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Links {
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
        driver.get("https://www.sugarcrm.com/request-demo/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try{
            WebElement acceptCoockiesButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")
            ));
            acceptCoockiesButton.click();
        } catch (Exception e) {
            System.out.println("Nie znaleziono baneru ciasteczek lub już zaakceptowano." + e.getMessage());
        }

        List<WebElement> AllLinks = driver.findElements(By.tagName("a"));


        System.out.println("Liczba linków na stronie: " + AllLinks.size());

        // Wypisz wszystkie linki
//        for (WebElement link : AllLinks) {
//            String text = link.getText(); // Pobierz tekst widoczny w elemencie
//            String url = link.getAttribute("href"); // Pobierz wartość atrybutu 'href'
//            System.out.println("Text: " + (text.isEmpty() ? "[No Text]" : text) + " | Link: " + (url == null ? "[No Href]" : url));
//        }
        // Wypisz wszystkie linki za pomocą stream()
        AllLinks.stream()
                .forEach(link -> {
                    String text = link.getText(); // Pobierz tekst widoczny w elemencie
                    String url = link.getAttribute("href"); // Pobierz wartość atrybutu 'href'
                    System.out.println("Text: " + (text.isEmpty() ? "[No Text]" : text) + " | Link: " + (url == null ? "[No Href]" : url));
                });


        driver.quit();
    }
}
