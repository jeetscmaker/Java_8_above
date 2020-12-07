package org.jk.serialization;

import java.io.Serializable;

/**
 * We will test various aspects of serialization with the use of  this class
 */
public class Book implements Serializable {
    public static int DEFAULT_PRICE = 5;
    private String bookName;
    private String isbn;
    private String author;
    private final String publisher = "BB";
    private transient double price;

    public Book() {
    }

    public Book(String b, String i, String a, double pr) {
        bookName = b;
        isbn = i;
        author = a;
        price = pr;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", isbn='" + isbn + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", price=" + price +
                ", Default price=" + DEFAULT_PRICE +
                '}';
    }
}