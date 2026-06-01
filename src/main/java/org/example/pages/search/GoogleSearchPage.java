package org.example.pages.search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchPage extends BaseSearchPage{

    public GoogleSearchPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait, By.name("q"), By.name("btnK"));
    }

    @Override
    public void open() {
        driver.get("https://www.google.com/");
    }
}
