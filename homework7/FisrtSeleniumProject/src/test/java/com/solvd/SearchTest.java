package com.solvd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTest {
    private WebDriver driver;
    private HomePage homePage;
    private SearchResultsPage resultsPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");

        homePage = new HomePage(driver);
        resultsPage = new SearchResultsPage(driver);
    }

    @Test
    public void testSearchForNonExistentProduct() {
        homePage.searchForProduct("qwerty123");

        SearchResultsPage resultsPage = new SearchResultsPage(driver);

        Assert.assertFalse(resultsPage.isResultsListNotEmpty(), "Unexpected products found for a non-existent query!");
    }

    @Test
    public void testSearchWithSpecialCharacters() {
        homePage.searchForProduct("!@#$%^&*");

        SearchResultsPage resultsPage = new SearchResultsPage(driver);

        Assert.assertFalse(resultsPage.isResultsListNotEmpty(), "Unexpected products found for a query with special characters!");
    }

    @Test
    public void testSearchWithEmptyQuery() {
        homePage.searchForProduct("");

        Assert.assertFalse(resultsPage.isResultsListNotEmpty(), "Unexpected results for an empty query!");
    }

    @Test
    public void testCaseInsensitiveSearch() {
        homePage.searchForProduct("laptop");
        List<String> lowerCaseResults = resultsPage.getProductTitles();

        homePage.searchForProduct("LAPTOP");
        List<String> upperCaseResults = resultsPage.getProductTitles();

        // Assert both results are the same
        Assert.assertEquals(lowerCaseResults, upperCaseResults,
                "Search results differ based on query case sensitivity!");
    }

    @Test
    public void testSearchResultsContainQuery() {
        String query = "Laptop";
        homePage.searchForProduct(query);

        SearchResultsPage resultsPage = new SearchResultsPage(driver);

        for (String title : resultsPage.getProductTitles()) {
            Assert.assertTrue(title.toLowerCase().contains(query.toLowerCase()),
                    "Product title does not contain the search query: " + title);
        }
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
