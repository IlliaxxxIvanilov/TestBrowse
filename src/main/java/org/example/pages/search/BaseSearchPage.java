package org.example.pages.search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseSearchPage {
    protected final WebDriver driver;
    protected final WebDriverWait wait;
    protected final By searchBox;
    protected final By searchButton;

    public BaseSearchPage(WebDriver driver, WebDriverWait wait, By searchBox,  By searchButton) {
        this.driver = driver;
        this.wait = wait;
        this.searchBox = searchBox;
        this.searchButton = searchButton;
    }

    abstract public void open();

    public void search(String keyword) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox)).sendKeys(keyword);
        this.wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }
}
