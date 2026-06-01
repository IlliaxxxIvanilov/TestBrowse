package org.example.tests;

import org.example.BaseTest;
import org.example.models.Book;
import org.example.pages.result.AmazonResultPage;
import org.example.pages.search.AmazonSearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class AmazonSearchTest extends BaseTest {
    private static final String KEYWORD = "Java";
    private static final String EXPECTED_TITLE = "Head First Java";

    @Test
    public void testAmazonBookSearch() {
        AmazonSearchPage amazonSearchPage = new AmazonSearchPage(driver, wait);
        amazonSearchPage.open();
        amazonSearchPage.selectBooksCategory();
        amazonSearchPage.search(KEYWORD);

        AmazonResultPage amazonResultPage = new AmazonResultPage(driver, wait);

        ArrayList<Book> books = amazonResultPage.getBooks();

        Assert.assertFalse(books.isEmpty(), "No books found");

        books.forEach(System.out::println);
        boolean found = books.stream().anyMatch(b -> b.getTitle().toLowerCase().contains(EXPECTED_TITLE.toLowerCase()));

        Assert.assertTrue(found, "Book not found: " + EXPECTED_TITLE);
    }
}
