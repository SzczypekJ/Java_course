package com.solvd.epam;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EpamTest {

    private static WebDriver driver;
    private static MainPage mainPage;
    private static IphonePage iphonePage;

    @BeforeAll
    static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.ebay.com");

        mainPage = new MainPage(driver);
        iphonePage = new IphonePage(driver);
    }

    @Test
    @Order(1)
    void searchForIphone() {
        mainPage.getSearch().sendKeys("Iphone 16 Pro Max");
        mainPage.getSearchButton().click();

        List<WebElement> allPhones = iphonePage.getAllPhonesNames();
        allPhones.forEach(phone -> System.out.println(phone.getAttribute("alt"))); // Wypisuje nazwy telefonów
    }

    @Test
    @Order(2)
    void selectSpecificIphone() throws InterruptedException {
        List<WebElement> allPhones = iphonePage.getAllPhonesNames();
        String expectedName = "Apple iPhone 16 Pro Max, 512GB, Titanium - Unlocked - E sim version - Excellent";

        WebElement firstPhone = allPhones.stream()
                .filter(phone -> expectedName.equals(phone.getAttribute("alt")))
                .findFirst()
                .orElseThrow(() -> new AssertionError("Phone not found"));

        firstPhone.click();
        Thread.sleep(5000);
    }

    @AfterAll
    static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
