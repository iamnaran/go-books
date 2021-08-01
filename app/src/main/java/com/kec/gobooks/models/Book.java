package com.kec.gobooks.models;

public class Book {

    private String bookName;
    private float price;
    private String bookAuthorName;

    public Book() {

    }

    public Book(String bookName, float price, String bookAuthorName) {
        this.bookName = bookName;
        this.price = price;
        this.bookAuthorName = bookAuthorName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getBookAuthorName() {
        return bookAuthorName;
    }

    public void setBookAuthorName(String bookAuthorName) {
        this.bookAuthorName = bookAuthorName;
    }
}
