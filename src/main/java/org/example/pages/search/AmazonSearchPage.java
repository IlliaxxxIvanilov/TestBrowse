package org.example.pages.search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonSearchPage extends BaseSearchPage{

    private By departmentSelect;

    public AmazonSearchPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait, By.id("twotabsearchtextbox"), By.id("nav-search-submit-button"));
        this.departmentSelect = By.id("searchDropdownBox");
    }

    @Override
    public void open() {
        driver.get("https://www.amazon.com");
    }

    public void selectBooksCategory() {
        WebElement dropdown = this.wait.until(ExpectedConditions.presenceOfElementLocated(this.departmentSelect));
        new Select(dropdown).selectByValue("search-alias=stripbooks-intl-ship");
    }
}
