package org.example.tests;

import org.example.BaseTest;
import org.example.models.Book;
import org.example.pages.detail.AmazonBookDetailPage;
import org.example.pages.result.AmazonResultPage;
import org.example.pages.search.AmazonSearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class AmazonSearchTest extends BaseTest {
    private static final String KEYWORD = "Java";

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

        AmazonBookDetailPage  amazonBookDetailPage = new AmazonBookDetailPage(driver, wait);
        amazonBookDetailPage.open("https://www.amazon.com/Head-First-Java-Brain-Friendly-Guide/dp/1491910771/ref=sr_1_6?crid=AYUK7X6JSNVS&dib=eyJ2IjoiMSJ9.uhUHpcgB7dTyfGvsG2lRw6LZMVbqOwc5-L4bqlsCc0N4xRRyFU8UqREe7am0AbgR2p79Be15FC4gBbWg7mWfZRwt1XDjCn60sn60FtEKGsgCn14ZXCuc2-7fvEJE4XVUUh9GHOHAoFEY0lJsiQHFvzWIzw9Ti6ViVsufVDI_g94T1xPWEMVDASIGVnKx1k__GImvZH6Us16Szqe6UEhWbMHj-M397FlK0ygyhSWipq8.y9fIsNbZaAAKbrNM3olfr9g33xlojVJMi6i694eHupw&dib_tag=se&keywords=Java&qid=1780313790&s=books&sprefix=java%2Cstripbooks-intl-ship%2C229&sr=1-6");
        Book book = amazonBookDetailPage.getBook();
        System.out.println("Expected book: " + book);

        boolean found = books.stream().anyMatch(b -> b.isEquals(book));
        Assert.assertTrue(found, "Book not found");
    }
}
