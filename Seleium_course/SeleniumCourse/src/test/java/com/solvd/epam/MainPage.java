package com.solvd.epam;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class MainPage {

    private WebDriver driver;

    @FindBy(xpath = "//input[@placeholder='Search for anything']")
    private WebElement search;

    @FindBy(xpath = "//span[@class='gh-search-button__label']")
    private WebElement searchButton;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
