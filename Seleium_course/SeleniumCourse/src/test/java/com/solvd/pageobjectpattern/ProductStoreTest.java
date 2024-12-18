package com.solvd.pageobjectpattern;

import com.solvd.testng.pages.*;
import com.solvd.testng.utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ProductStoreTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private ProductPage productPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private AllProductsPage allProductsPage;

    private String price;
    private String productName;

    @BeforeClass
    @Parameters({"browser"})
    public void setUp(@Optional("chrome") String browser) {
        driver = WebDriverFactory.getDriver(browser);
        allProductsPage = new AllProductsPage(driver);
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @Test(priority = 1)
    public void testLogin() throws InterruptedException {
        driver.get("https://www.demoblaze.com/index.html");

        loginPage.openLoginModal();
        Thread.sleep(1000);
        loginPage.login("jakubszczypek", "1234");
        Thread.sleep(1000);
        Assert.assertEquals(loginPage.getWelcomeText(), "Welcome jakubszczypek");
    }

    @Test(priority = 2)
    public void testAddProductToCart() throws InterruptedException {
        productName = allProductsPage.getProductName();
        allProductsPage.selectProduct();
        Thread.sleep(1000);

        price = productPage.getProductPrice();
        productPage.addToCart();

        productPage.goToCart();
        Thread.sleep(1000);

        Assert.assertEquals(cartPage.getProductNameInTheCart(), productName);
        Assert.assertTrue(price.contains(cartPage.getProductPriceInTheCart()));
    }

    @Test(priority = 3)
    public void testPurchaseProduct() throws InterruptedException {
        cartPage.placeOrder();
        Thread.sleep(1000);

        // Filling the purchase details
        String name = "Jakub";
        String country = "Poland";
        String city = "Cracow";
        String creditCard = "4111111111111111";
        String month = "January";
        String year = "2024";

        checkoutPage.fillCheckoutDetails(name, country, city, creditCard, month, year);
        Thread.sleep(1000);
        checkoutPage.completePurchase();
        Thread.sleep(1000);

        // Validate the purchase summary details
        String purchaseDetails = checkoutPage.getPurchaseDetails();
        Assert.assertTrue(purchaseDetails.contains("Id:"), "Purchase details missing ID!");
        Assert.assertTrue(purchaseDetails.contains("Amount: " + price), "Purchase amount mismatch!");
        Assert.assertTrue(purchaseDetails.contains("Card Number: " + creditCard), "Credit card mismatch!");
        Assert.assertTrue(purchaseDetails.contains("Name: " + name), "Name mismatch in purchase details!");

        System.out.println("Test passed: Purchase details are correct!");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
