package org.example.pages.result;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GoogleResultPage extends BaseResultPage {
    private final By resultTitles;

    public GoogleResultPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait, By.id("search"));

        this.resultTitles = By.cssSelector("h3");
    }

    public List<WebElement> getResults() {
        return this.driver.findElements(resultTitles);
    }
}
