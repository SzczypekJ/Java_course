package com.solvd.pageobjectpattern;

import com.solvd.testng.pages.*;
import com.solvd.testng.utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

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
    }

    @Test(priority = 1)
    public void testLogin() throws InterruptedException {
        loginPage = new LoginPage(driver);

        loginPage.open();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        loginPage.openLoginModal();
        wait.until(ExpectedConditions.visibilityOf(loginPage.getUsernameField()));

        loginPage.login("jakubszczypek", "1234");

        wait.until(ExpectedConditions.visibilityOf(loginPage.getWelcomeTextElement()));
        Assert.assertEquals(loginPage.getWelcomeText(), "Welcome jakubszczypek",
                "Login failed or welcome message is incorrect!");
    }

    @Test(priority = 2)
    public void testAddProductToCart() throws InterruptedException {
        allProductsPage = new AllProductsPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(allProductsPage.getProductNameElement()));
        productName = allProductsPage.getProductName();
        allProductsPage.selectProduct();

        wait.until(ExpectedConditions.visibilityOf(productPage.getProductPriceElement()));
        price = productPage.getProductPrice();
        productPage.addToCart();

        productPage.goToCart();

        wait.until(ExpectedConditions.visibilityOf(cartPage.getProductNameInTheCartElement()));
        wait.until(ExpectedConditions.visibilityOf(cartPage.getProductPriceInTheCartElement()));
        Assert.assertEquals(cartPage.getProductNamesInCart().get(0), productName,
                "Product name in the cart does not match the selected product!");
        Assert.assertTrue(price.contains(cartPage.getProductPricesInCart().get(0)),
                "Product price in the cart does not match the selected product!");
    }

    @Test(priority = 3)
    public void testAddSingleProductPurchase() throws InterruptedException {
        testPurchaseProduct(price);
    }


    @Test(priority = 4, description = "The new test where I will use the list of web elements")
    public void testPurchaseProductWithList() throws InterruptedException {
        allProductsPage = new AllProductsPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);

        driver.get("https://www.demoblaze.com/index.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(allProductsPage.getLogoutButton()));
        allProductsPage.logout();

        testLogin();


        List<String> namesOfProducts = new ArrayList<>();
        List<String> pricesOfProducts = new ArrayList<>();

        // Product 1
        namesOfProducts.add(allProductsPage.getProductNameByIndex(0));
        pricesOfProducts.add(allProductsPage.addProductToCartByIndex(0));

        // Product 2
        namesOfProducts.add(allProductsPage.getProductNameByIndex(1));
        pricesOfProducts.add(allProductsPage.addProductToCartByIndex(1));

        // Product 3
        namesOfProducts.add(allProductsPage.getProductNameByIndex(5));
        pricesOfProducts.add(allProductsPage.addProductToCartByIndex(5));

        allProductsPage.goToCart();

        wait.until(ExpectedConditions.visibilityOfAllElements(cartPage.getProductNamesInCartElement()));
        wait.until(ExpectedConditions.visibilityOfAllElements(cartPage.getProductPricesInCartElement()));

        List<String> cartProductNames = cartPage.getProductNamesInCart();
        List<String> cartProductPrices = cartPage.getProductPricesInCart();

        // Sort lists using stream
        namesOfProducts = namesOfProducts.stream().sorted().toList();
        cartProductNames = cartProductNames.stream().sorted().toList();
        pricesOfProducts = pricesOfProducts.stream().sorted().toList();
        cartProductPrices = cartProductPrices.stream().sorted().toList();

        Assert.assertEquals(cartProductNames, namesOfProducts,
                "Product names in the cart do not match the selected products!");
        Assert.assertEquals(cartProductPrices, pricesOfProducts,
                "Product prices in the cart do not match the selected products!");

        String totalPrice = cartPage.getTotalPrice();
        int actualTotalPrice = Integer.parseInt(totalPrice);

        int expectedTotalPrice = cartProductPrices.stream()
                .mapToInt(Integer::parseInt)
                .sum();

        Assert.assertEquals(actualTotalPrice, expectedTotalPrice, "Total price mismatch!");

        testPurchaseProduct(totalPrice);
    }

//    @Test(priority = 5, description = "Logout the user")
//    public void testLogout() throws InterruptedException {
//        allProductsPage = new AllProductsPage(driver);
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOf(allProductsPage.getLogoutButton()));
//
//        allProductsPage.logout();
//    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void testPurchaseProduct(String totalPrice) throws InterruptedException {
        checkoutPage = new CheckoutPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        cartPage.placeOrder();

        wait.until(ExpectedConditions.visibilityOf(checkoutPage.getNameField()));
        wait.until(ExpectedConditions.visibilityOf(checkoutPage.getCountryField()));
        wait.until(ExpectedConditions.visibilityOf(checkoutPage.getCityField()));
        wait.until(ExpectedConditions.visibilityOf(checkoutPage.getCardField()));
        wait.until(ExpectedConditions.visibilityOf(checkoutPage.getMonthField()));
        wait.until(ExpectedConditions.visibilityOf(checkoutPage.getYearField()));

        // Filling the purchase details
        String name = "Jakub";
        String country = "Poland";
        String city = "Cracow";
        String creditCard = "4111111111111111";
        String month = "January";
        String year = "2024";

        checkoutPage.fillCheckoutDetails(name, country, city, creditCard, month, year);

        wait.until(ExpectedConditions.elementToBeClickable(checkoutPage.getPurchaseButton()));
        checkoutPage.completePurchase();
        wait.until(ExpectedConditions.visibilityOf(checkoutPage.getPurchaseDetailsElement()));

        // Validate the purchase summary details
        String purchaseDetails = checkoutPage.getPurchaseDetails();
        Assert.assertTrue(purchaseDetails.contains("Id:"), "Purchase details missing ID!");
        Assert.assertTrue(purchaseDetails.contains("Amount: " + totalPrice), "Purchase amount mismatch!");
        Assert.assertTrue(purchaseDetails.contains("Card Number: " + creditCard), "Credit card mismatch!");
        Assert.assertTrue(purchaseDetails.contains("Name: " + name), "Name mismatch in purchase details!");

        System.out.println("Test passed: Purchase details are correct!");

        checkoutPage.confirmPurchase();
    }
}
