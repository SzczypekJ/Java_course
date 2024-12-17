package com.solvd.testng.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyTitle {

    @Test(priority = 1, description = "Check the website title")
    public void titleTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com");

        String excpectedTitle = "Electronics, Cars, Fashion, Collectibles & More | eBay";

        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, excpectedTitle, "The title is not correct");
        
        driver.close();
    }
}
