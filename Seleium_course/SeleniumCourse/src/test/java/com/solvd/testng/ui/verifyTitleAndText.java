package com.solvd.testng.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class verifyTitleAndText {

    @Test(priority = 1, description = "Check the website title")
    public void titleTest() {
        SoftAssert softAssert = new SoftAssert();

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com");

        String excpectedTitle = "Electronics, Cars, Fashion, Collectibles & More | eBay";

        String actualTitle = driver.getTitle();

        System.out.println("Verifying the title");
        softAssert.assertEquals(actualTitle, excpectedTitle, "The title is not correct");

        String expectedText = "Search";
        String message = "The text is not correct";
        String actualText = driver.findElement(By.xpath("//*[@id=\"gh-btn\"]")).getDomProperty("value");

        System.out.println("Verifying the text");
        softAssert.assertEquals(actualText, expectedText, message);

        softAssert.assertAll();
        
        driver.close();
    }
}
