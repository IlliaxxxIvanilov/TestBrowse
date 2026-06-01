package org.example.models;

public class Book {
    private String title;
    private String author;
    private String price;
    private boolean isBestseller;

    public Book(String title, String author, String price, boolean isBestseller) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isBestseller = isBestseller;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getPrice() {
        return this.price;
    }

    public boolean isBestseller() {
        return this.isBestseller;
    }

    public String toString() {
        return "Title: " + this.title + "| Author: " + this.author + "| Price: " + this.price + "| Bestseller: " + (this.isBestseller ? "yes" : "no");
    }
}
