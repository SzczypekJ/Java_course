package com.solvd.traintestng.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {

    private WebDriver driver;

    @FindBy(css = ".inventory_item")
    private List<WebElement> allProducts;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement cartButton;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getAllProducts() {
        return allProducts;
    }

    public String getProductName(int index) {
        return allProducts.get(index).findElement(By.cssSelector(".inventory_item_name")).getText();
    }

    public String getProductPrice(int index) {
        return allProducts.get(index).findElement(By.cssSelector(".inventory_item_price")).getText();
    }

    public void addProductToCart(int index) {
        allProducts.get(index).findElement(By.cssSelector(".btn_inventory")).click();
    }

    public void goToCart() {
        cartButton.click();
    }
}