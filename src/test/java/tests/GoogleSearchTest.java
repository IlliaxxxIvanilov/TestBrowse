package tests;

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
import pages.GooglePage;

import java.time.Duration;
import java.util.List;

public class GoogleSearchTest {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static GooglePage googlePage;
    private static final String KEYWORD = "Java";

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        googlePage = new GooglePage(driver, wait);
    }

    @Test
    public void testGoogleSearch() {
        googlePage.open();
        googlePage.search(KEYWORD);

        List<WebElement> results = googlePage.getResults();
        Assert.assertFalse("No results", results.isEmpty());

        long count = results.stream().filter(r -> r.getText().toLowerCase().contains(KEYWORD.toLowerCase())).count();

        Assert.assertTrue("Doesnt contain keyword", count > 0);
    }

    @AfterClass
    public static void tearDown() {
        if (driver != null) driver.quit();
    }
}
