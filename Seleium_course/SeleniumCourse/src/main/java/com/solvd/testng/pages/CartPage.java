package com.solvd.testng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    private WebDriver driver;

    @FindBy(css = "#tbodyid > tr > td:nth-child(2)")
    private WebElement productName;

    @FindBy(css = "#tbodyid > tr > td:nth-child(3)")
    private WebElement productPrice;

    @FindBy(xpath = "//button[@data-target='#orderModal']")
    private WebElement placeOrderButton;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getProductNameInTheCart() {
        return productName.getText();
    }

    public String getProductPriceInTheCart() {
        String rawPrice = productPrice.getText();
        return rawPrice.replaceAll("[^0-9]", "");
    }

    public void placeOrder() {
        placeOrderButton.click();
    }
}
