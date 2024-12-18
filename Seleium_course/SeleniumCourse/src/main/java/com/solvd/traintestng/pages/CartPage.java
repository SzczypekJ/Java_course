package com.solvd.traintestng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {

    private WebDriver driver;

    @FindBy(css = ".inventory_item_name")
    private List<WebElement> productNamesInCart;

    @FindBy(css = ".inventory_item_price")
    private List<WebElement> productPricesInCart;

    @FindBy(css = ".cart_button")
    private List<WebElement> removeButtons;

    @FindBy(css = ".checkout_button")
    private WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getProductNamesInCart() {
        return productNamesInCart;
    }

    public List<WebElement> getProductPricesInCart() {
        return productPricesInCart;
    }

    public String getProductNameInCart(int index) {
        return productNamesInCart.get(index).getText();
    }

    public String getProductPriceInCart(int index) {
        return productPricesInCart.get(index).getText();
    }

    public void removeProduct(int index) {
        removeButtons.get(index).click();
    }

    public void clickCheckoutButton() {
        checkoutButton.click();
    }
}