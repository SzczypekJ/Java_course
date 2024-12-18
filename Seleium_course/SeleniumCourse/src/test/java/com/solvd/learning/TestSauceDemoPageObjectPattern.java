package com.solvd.learning;

import com.solvd.testng.pages.LoginPage;
import com.solvd.traintestng.pages.CartPage;
import com.solvd.traintestng.pages.LoginPageSauce;
import com.solvd.traintestng.pages.MainPage;
import com.solvd.traintestng.utils.WebDriverFactorySauce;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class TestSauceDemoPageObjectPattern {
    
    private WebDriver driver;
    private LoginPageSauce loginPageSauce;
    private MainPage mainPage;
    private CartPage cartPage;

    @BeforeClass
    @Parameters({"browser"})
    public void setUp(@Optional("chrome") String browser) {
        driver = WebDriverFactorySauce.getDriver(browser);
        loginPageSauce = new LoginPageSauce(driver);
        mainPage = new MainPage(driver);
        cartPage = new CartPage(driver);
    }

    @Test(priority = 1, description = "Logging test")
    public void testLogin() {
        driver.get("https://www.saucedemo.com");

        loginPageSauce.login("standard_user", "secret_sauce");
    }

    @Test(priority = 2, description = "Get all products from the page")
    public void testGetAllProducts() {
        List<WebElement> products = mainPage.getAllProducts();
        System.out.println("Number of products: " + products.size());

        for (int i = 0; i < products.size(); i++) {
            String name = mainPage.getProductName(i);
            String price = mainPage.getProductPrice(i);
            System.out.println("Product " + (i + 1) + ": " + name + " - " + price);
        }
    }

    @Test(priority = 3, description = "Add some products to the cart")
    public void testAddSomeProductToCart() {
        mainPage.addProductToCart(0);
        mainPage.addProductToCart(2);
        mainPage.addProductToCart(4);
        System.out.println("Added some product to cart!");
    }

    @Test(priority = 4, description = "Go to the cart page and check if you added good product to the cart")
    public void testGoToCartPage() {
        mainPage.goToCart();

        List<WebElement> namesInCart = cartPage.getProductNamesInCart();
        List<WebElement> pricesInCart = cartPage.getProductPricesInCart();

        String[] expectedNames = {"Sauce Labs Backpack", "Sauce Labs Bolt T-Shirt", "Sauce Labs Onesie"};
        String[] expectedPrices = {"$29.99", "$15.99", "$7.99"};

        for (int i = 0; i < expectedNames.length; i++) {
            String actualName = namesInCart.get(i).getText();
            String actualPrice = pricesInCart.get(i).getText();

            System.out.println("Checking product " + (i + 1) + ": " + actualName + " - " + actualPrice);

            Assert.assertEquals(actualName, expectedNames[i], "Product name mismatch in cart!");
            Assert.assertEquals(actualPrice, expectedPrices[i], "Product price mismatch in cart!");
        }

        System.out.println("All products in the cart are correct!");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
