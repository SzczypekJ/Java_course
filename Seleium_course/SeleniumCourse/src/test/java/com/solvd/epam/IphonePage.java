package com.solvd.epam;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
public class IphonePage {

    private WebDriver driver;

    @FindBy(xpath = "//img[@src]")
    private List<WebElement> allPhonesNames;

    public IphonePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
