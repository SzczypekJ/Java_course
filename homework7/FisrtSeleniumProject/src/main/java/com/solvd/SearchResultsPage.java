package com.solvd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultsPage {
    private WebDriver driver;

    @FindBy(css = "span.a-size-medium.a-color-base.a-text-normal")
    private List<WebElement> productTitles;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isResultsListNotEmpty() {
        try {
            System.out.println("Number of elements matched by 'productTitles': " + productTitles.size());
            boolean hasResults = !productTitles.isEmpty() &&
                    productTitles.stream().allMatch(WebElement::isDisplayed);
            if (!hasResults) {
                System.out.println("No results found. Product titles list is empty or elements are not displayed.");
            }
            return hasResults;
        } catch (Exception e) {
            System.err.println("Error while fetching product titles: " + e.getMessage());
            return false;
        }
    }



    public void printAllProductTitles() {
        System.out.println("Product Titles:");
        productTitles.forEach(title -> System.out.println(title.getText()));
    }

    public List<String> getProductTitles() {
        return productTitles.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
