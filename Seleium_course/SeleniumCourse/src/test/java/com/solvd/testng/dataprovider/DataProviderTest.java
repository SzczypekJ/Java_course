package com.solvd.testng.dataprovider;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import javax.xml.crypto.Data;

public class DataProviderTest {

    @Test(dataProvider = "getData", dataProviderClass = DataProvider.class)
    public void testDataProvider(String usernamew, String password) {
        // Inicjalizacja przeglądarki
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");

        // Inicjalizacja strony głównej
        MainPager mainPager = new MainPager(driver);

        mainPager.login(usernamew, password);

        driver.quit();
    }
}
