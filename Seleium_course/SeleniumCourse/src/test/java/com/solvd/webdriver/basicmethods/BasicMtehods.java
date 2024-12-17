package com.solvd.webdriver.basicmethods;

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

public class BasicMtehods {
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

        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);

        String title = driver.getTitle();
        System.out.println(title);

        String pageSource = driver.getPageSource();
        System.out.println(pageSource);

        driver.navigate().to("https://www.google.com");
        Thread.sleep(2000);

        driver.navigate().to("https://www.saucedemo.com");

        // Znajduje pole tekstowe dla nazwy użytkownika (po ID "user-name") i wprowadza tekst "standard_user".
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        // Znajduje pole tekstowe dla hasła (po ID "password") i wprowadza tekst "secret_sauce".
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        // Znajduje przycisk logowania (po XPath) i klika w niego.
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

        List<WebElement> webElements = driver.findElements(By.xpath("//div[@class=\"inventory_list\"]/div"));

        System.out.println(webElements);

        driver.navigate().to("https://www.sugarcrm.com");

        // Obsługa ciasteczek (jeśli widoczny jest przycisk akceptacji ciasteczek)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll"))); // Identyfikator przycisku akceptacji ciasteczek
            acceptCookiesButton.click(); // Kliknięcie przycisku
        } catch (Exception e) {
            System.out.println("Nie znaleziono baneru ciasteczek lub już zaakceptowano.");
        }

        String windowHandle = driver.getWindowHandle();

        // Dynamiczne oczekiwanie na element
        WebElement linkElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"slide-67599cebcd783\"]/div/div/div[1]/div/div/div[1]/div/a")
        ));

        // Kliknięcie elementu, gdy jest widoczny
        linkElement.click();

        Set<String> windowhandles1 = driver.getWindowHandles();
        System.out.println(windowhandles1);

        Thread.sleep(2000);

        // Zamknięcie przeglądarki
        driver.quit();
    }
}
