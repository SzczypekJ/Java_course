package com.solvd.webelements;

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
import java.util.Set;

public class WebElements {
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


        driver.findElement(By.name("input_3.3")).sendKeys("Testing");

        Thread.sleep(2000);

        driver.findElement(By.name("input_3.3")).clear();

        Thread.sleep(2000);

        String className = driver.findElement(By.name("input_3.3")).getAttribute("placeholder");
        System.out.println("Class attribute: " + className);

        System.out.println(driver.findElement(By.xpath("//*[@id=\"gform_submit_button_1\"]")).getCssValue("text-transform"));

        System.out.println(driver.findElement(By.xpath("//*[@id=\"gform_submit_button_1\"]")).getSize());

        System.out.println(driver.findElement(By.xpath("//*[@id=\"gform_submit_button_1\"]")).getLocation());

        System.out.println(driver.findElement(By.xpath("//*[@id=\"gform_submit_button_1\"]")).getTagName());

        System.out.println(driver.findElement(By.xpath("//*[@id=\"gform_submit_button_1\"]")).getText());

        System.out.println(driver.findElement(By.xpath("//*[@id=\"gform_submit_button_1\"]")).isDisplayed());

        System.out.println(driver.findElement(By.xpath("//*[@id=\"gform_submit_button_1\"]")).isEnabled());

        System.out.println(driver.findElement(By.xpath("//*[@id=\"gform_submit_button_1\"]")).isSelected());

        System.out.println(driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[2]/div/div/div[1]/h2")).getText());

        driver.quit();
    }
}
