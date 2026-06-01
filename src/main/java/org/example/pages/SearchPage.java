package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By searchBox;
    private final By searchButton;

    public SearchPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;

        this.searchBox = By.name("q");
        this.searchButton = By.name("btnK");
    }

    public void open() {
        driver.get("https://www.google.com/");
    }

    public void search(String keyword) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox)).sendKeys(keyword);
        this.wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }
}
