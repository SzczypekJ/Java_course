package com.solvd.webdriver.switching;

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
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public class SwicthingBetweenWindows {

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

        driver.get("https://www.salesforce.com/eu/?ir=1");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try{
            WebElement acceptCoockiesButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.id("onetrust-accept-btn-handler")
            ));
            acceptCoockiesButton.click();
        } catch (Exception e) {
            System.out.println("Nie znaleziono baneru ciasteczek lub już zaakceptowano." + e.getMessage());
        }
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[@aria-label='Try for free: Salesforce Starter']")).click();
        Thread.sleep(2000);

        Set<String> windows = driver.getWindowHandles();
        System.out.println(windows);

        Iterator<String> iterator = windows.iterator();
        String parentwindow = iterator.next();
        String childwindow = iterator.next();

        driver.switchTo().window(childwindow);

        // Z obłsugą errora - jak nie itnieje kolejne okno to program się zakończy
//        String childwindow = null;
//
//        // Jeśli istnieje więcej niż jedno okno, pobierz uchwyt dziecka.
//        if (iterator.hasNext()) {
//            childwindow = iterator.next();
//            driver.switchTo().window(childwindow); // Przełącz na okno child.
//        } else {
//            System.out.println("Nie znaleziono uchwytu nowego okna.");
//            driver.quit();
//            return;
//        }


        driver.findElement(By.name("UserFirstName")).sendKeys("John");
        Thread.sleep(2000);
        driver.findElement(By.name("UserLastName")).sendKeys("Smith");
        Thread.sleep(2000);


        driver.close();
    }
}
