package com.solvd.webdriver.first;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoAutomation {

    public static void main(String[] args) throws InterruptedException {
        // Stworzenie instancji WebDrivera dla przeglądarki Chrome.
        // ChromeDriver to klasa pozwalająca na sterowanie przeglądarką Google Chrome.
        WebDriver driver = new ChromeDriver();

        // Maksymalizacja okna przeglądarki, aby w pełni wykorzystać ekran.
        driver.manage().window().maximize();

        // Przejście na stronę eBay poprzez podanie URL.
        driver.get("https://www.ebay.com/");

        // Inicjalizacja obiektu WebDriverWait, który będzie oczekiwał na widoczność elementów.
        // Okres oczekiwania jest ustawiony na maksymalnie 10 sekund.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Znalezienie pola wyszukiwania na stronie eBay (po ID "gh-ac"),
        // ale dopiero po upewnieniu się, że jest widoczne na stronie.
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gh-ac")));

        // Wpisanie frazy "mobile" w pole wyszukiwania.
        searchBox.sendKeys("mobile");

        // Znalezienie przycisku wyszukiwania na stronie (po ID "gh-btn") i kliknięcie go.
        WebElement searchButton = driver.findElement(By.id("gh-search-btn"));
        searchButton.click();

        // Dodanie opóźnienia, aby można było zobaczyć wynik akcji przed zamknięciem przeglądarki.
        // Używane w celach demonstracyjnych (w rzeczywistych projektach preferowane są dynamiczne oczekiwania).
        Thread.sleep(2000);

        // Zamknięcie okna przeglądarki. Metoda close() zamyka tylko bieżące okno.
        driver.close();
    }
} 