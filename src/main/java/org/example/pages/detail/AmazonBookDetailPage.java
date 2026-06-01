package org.example.pages.detail;

import org.example.models.Book;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonBookDetailPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By title;
    private final By author;
    private final By price;
    private final By bestseller;

    public AmazonBookDetailPage(WebDriver driver,  WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.title = By.cssSelector("#productTitle");
        this.author = By.cssSelector(".author a");
        this.price = By.cssSelector("span.a-size-base.a-color-secondary");
        this.bestseller = By.cssSelector("#best-seller-rank");
    }

    public void open(String url) {
        driver.get(url);
    }

    public Book getBook() {
        String titleText = wait.until(ExpectedConditions.visibilityOfElementLocated(title)).getText();

        String authorText = "";
        try {
            authorText = driver.findElement(this.author).getText();
        } catch (Exception e) {}

        String priceText = "";
        try {
            priceText =  driver.findElement(this.price).getText();
        } catch (Exception e) {}

        boolean bestseller = !driver.findElements(this.bestseller).isEmpty();

        return new Book(titleText, authorText, priceText, bestseller);
    }
}
