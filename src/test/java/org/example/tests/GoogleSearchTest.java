package org.example.tests;

import org.example.pages.ResultPage;
import org.example.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.example.BaseTest;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleSearchTest extends BaseTest {
    private static final String KEYWORD = "Java";

    @Test
    public void testGoogleSearch() {
        SearchPage searchPage = new SearchPage(driver, wait);
        searchPage.open();
        searchPage.search(KEYWORD);

        ResultPage resultPage = new ResultPage(driver, wait);
        resultPage.waitForSearchResults();

        List<WebElement> results = resultPage.getResults();
        Assert.assertFalse(results.isEmpty(), "No results");

        long count = results.stream().filter(r -> r.getText().toLowerCase().contains(KEYWORD.toLowerCase())).count();

        Assert.assertTrue(count > 0, "Doesnt contain keyword");
    }
}
