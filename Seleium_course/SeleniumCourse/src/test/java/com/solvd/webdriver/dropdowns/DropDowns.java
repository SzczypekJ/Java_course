package com.solvd.webdriver.dropdowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
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

public class DropDowns {
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

        Select select = new Select(driver.findElement(By.id("input_1_8")));

        select.selectByValue("level9");
        Thread.sleep(2000);

        select.selectByIndex(1);
        Thread.sleep(2000);

        select.selectByVisibleText("101 - 250 employees");
        Thread.sleep(2000);

        // Przykład na multiselect w dropdown - nie znalazłem żadnej strony z czymś takim
        // Otwieramy przykładową stronę
//        driver.get("https://www.sugarcrm.com/request-demo/");

        // Tworzymy nowy selector
//       Select multiselector = new Select(driver.findElement(By.id("input_2_8")));
//
         // najpierw zaznaczamy wszystkie interesujące nas opcje
//        multiselector.selectByValue("level10");
//        multiselector.selectByValue("level9");
//        multiselector.selectByValue("level8");

        // Tworzymy listę zawierającą wszystkie zaznaczone opcje przez multiselector
//        List<WebElement> allItems = multiselector.getAllSelectedOptions();
//        System.out.println(allItems.size());

        // Możemy odznaczyć wszystkie albo część opcji za pomocą metod deselectAll, deselectByIndex itd.
//        multiselector.deselectAll();
        driver.quit();
    }
}
