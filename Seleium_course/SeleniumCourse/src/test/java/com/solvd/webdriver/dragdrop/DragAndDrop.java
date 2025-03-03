package com.solvd.webdriver.dragdrop;

import com.beust.ah.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class DragAndDrop {

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

        driver.get("https://jqueryui.com/droppable/");

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        try{
//            WebElement acceptCoockiesButton = wait.until(ExpectedConditions.elementToBeClickable(
//                    By.id("onetrust-accept-btn-handler")
//            ));
//            acceptCoockiesButton.click();
//        } catch (Exception e) {
//            System.out.println("Nie znaleziono baneru ciasteczek lub już zaakceptowano." + e.getMessage());
//        }
        Thread.sleep(2000);
        WebElement frame = driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));
        driver.switchTo().frame(frame);

        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));
        Thread.sleep(2000);

        Actions action = new Actions(driver);
        action.dragAndDrop(drag, drop).perform();
        Thread.sleep(2000);

        driver.close();
    }
}
