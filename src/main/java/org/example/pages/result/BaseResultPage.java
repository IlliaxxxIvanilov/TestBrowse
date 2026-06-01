package org.example.pages.result;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseResultPage {
    protected final WebDriver driver;
    protected final WebDriverWait wait;
    protected By searchResults;

    public BaseResultPage(WebDriver driver, WebDriverWait wait, By searchResults) {
        this.driver = driver;
        this.wait = wait;
        this.searchResults = searchResults;
    }

    public BaseResultPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void waitForSearchResults() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.searchResults));
    }
}
