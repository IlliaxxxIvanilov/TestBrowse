package org.example.tests;

import org.example.pages.result.GoogleResultPage;
import org.example.pages.search.GoogleSearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.example.BaseTest;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleSearchTest extends BaseTest {
    private static final String KEYWORD = "Java";

    @Test
    public void testGoogleSearch() {
        GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver, wait);
        googleSearchPage.open();
        googleSearchPage.search(KEYWORD);

        GoogleResultPage googleResultPage = new GoogleResultPage(driver, wait);
        googleResultPage.waitForSearchResults();

        List<WebElement> results = googleResultPage.getResults();
        Assert.assertFalse(results.isEmpty(), "No results");

        long count = results.stream().filter(r -> r.getText().toLowerCase().contains(KEYWORD.toLowerCase())).count();

        Assert.assertTrue(count > 0, "Doesnt contain keyword");
    }
}
