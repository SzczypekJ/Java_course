package com.solvd.alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PromptAlerts {

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

        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try{
            WebElement acceptCoockiesButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.id("accept-choices")
            ));
            acceptCoockiesButton.click();
        } catch (Exception e) {
            System.out.println("Nie znaleziono baneru ciasteczek lub już zaakceptowano." + e.getMessage());
        }

        WebElement frame1 = driver.findElement(By.id("iframeResult"));

        driver.switchTo().frame(frame1);
        driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.sendKeys("Jakub Szczypek");
        Thread.sleep(2000);

        alert.accept();
        Thread.sleep(2000);

        driver.switchTo().parentFrame();
        System.out.println(driver.getTitle());
        Thread.sleep(2000);

//        driver.close();
    }
}
