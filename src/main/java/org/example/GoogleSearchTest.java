package org.example;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GoogleSearchTest {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static final String KEYWORD = "Java";

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void testGoogleSearch() {
        driver.get("https://www.google.com");
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        searchBox.sendKeys(KEYWORD);

        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("btnK")));
        searchButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));

        List<WebElement> results = driver.findElements(By.cssSelector("h3"));
        Assert.assertFalse("No results", results.isEmpty());

        /*for (WebElement result : results) {
            String title = result.getText().toLowerCase();
            Assert.assertTrue("Doesnt contain keyword", title.contains(KEYWORD.toLowerCase()));
        }*/
        long count = results.stream().filter(r -> r.getText().toLowerCase().contains(KEYWORD.toLowerCase())).count();

        Assert.assertTrue("Doesnt contain keyword", count > 0);
    }

    @AfterClass
    public static void tearDown() {
        if (driver != null) driver.quit();
    }
}
