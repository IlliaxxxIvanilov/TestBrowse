package org.example.pages.result;

import org.example.models.Book;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class AmazonResultPage extends BaseResultPage {

    private final By results;

    public AmazonResultPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);

        this.results = By.cssSelector("[data-component-type='s-search-result']");
    }

    public ArrayList<Book> getBooks() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.results));
        List<WebElement> items = driver.findElements(this.results);
        ArrayList<Book> books = new ArrayList<>();

        for (WebElement item : items) {
            try {
                String title = item.findElement(By.cssSelector("h2 span")).getText();

                String author = "";
                try {
                    author = item.findElement(By.cssSelector("a.a-size-base")).getText();
                } catch (Exception e) {}

                String price = "";
                try {
                    String whole = item.findElement(By.cssSelector(".a-price-whole")).getText();
                    String fraction = item.findElement(By.cssSelector(".a-price-fraction")).getText();
                    price = "$" + whole + "." +  fraction;
                } catch (Exception e) {}

                boolean bestseller = !item.findElements(By.id("BEST_SELLER")).isEmpty();

                books.add(new Book(title, author, price, bestseller));
            } catch (Exception e) {}
        }
        return books;
    }
}
