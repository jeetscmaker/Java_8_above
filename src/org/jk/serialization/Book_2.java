package org.jk.serialization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * @author Jitendra
 * This class implements Externalizable for customized serialization.
 */
public class Book_2 implements Externalizable {
    private static final long serialVersionUID = 121L;

    public static int DEFAULT_PRICE = 5;
    private String bookName;
    private String isbn;
    private String author;
    private final String publisher = "BB";
    private transient double price;

    public Book_2() {
    }

    public Book_2(String b, String i, String a, double pr) {
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
        return "Book_2{" +
                "bookName='" + bookName + '\'' +
                ", isbn='" + isbn + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", price=" + price +
                ", Default price=" + DEFAULT_PRICE +
                '}';
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(bookName);
        out.writeObject(isbn);
        /* Even if price is declared as 'transient' but it will be serialized because
         * here we are doing a custom serialization.
         */
        out.writeDouble(price);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        bookName = (String) in.readObject();
        isbn = (String) in.readObject();
        price = in.readDouble();
    }
}
