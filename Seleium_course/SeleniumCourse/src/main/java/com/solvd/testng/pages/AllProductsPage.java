package com.solvd.testng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllProductsPage {

    private WebDriver driver;

    @FindBy(xpath = "//a[@href='prod.html?idp_=3' and @class='hrefch']")
    private WebElement nexusProduct;

    public AllProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectProduct() {
        nexusProduct.click();
    }

    public String getProductName() {
        return nexusProduct.getText();
    }

}
