package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GooglePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By searchBox;
    private final By searchButton;
    private final By searchResults;
    private final By resultTitles;

    public GooglePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;

        this.searchBox = By.name("q");
        this.searchButton = By.name("btnK");
        this.searchResults = By.id("search");
        this.resultTitles = By.cssSelector("h3");
    }

    public void open() {
        driver.get("https://www.google.com");
    }

    public void search(String keyword) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox)).sendKeys(keyword);
        this.wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(searchResults));
    }

    public List<WebElement> getResults() {
        return this.driver.findElements(resultTitles);
    }
}
