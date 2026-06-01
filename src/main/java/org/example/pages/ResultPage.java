package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ResultPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By searchResults;
    private final By resultTitles;

    public ResultPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;

        this.searchResults = By.id("search");
        this.resultTitles = By.cssSelector("h3");
    }

    public void waitForSearchResults() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(searchResults));
    }

    public List<WebElement> getResults() {
        return this.driver.findElements(resultTitles);
    }
}
