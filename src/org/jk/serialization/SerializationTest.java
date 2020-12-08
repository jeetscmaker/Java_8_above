package org.jk.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * A test class for testing java serialization properties.
 * Serializability of a class is enabled by the class implementing the java.io.Serializable
 * interface. Classes that do not implement this interface will not have any of their state
 * serialized or deserialized. All subtypes of a serializable class are themselves serializable.
 * The serialization interface has no methods or fields and serves only to identify the
 * semantics of being serializable.
 */
public class SerializationTest {
    public static void main(String[] args) throws Exception {
        Book b = new Book("abc", "12345", "James", 52);

        FileOutputStream fileOutputStream = new FileOutputStream("myBook.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(b);
        objectOutputStream.flush();
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("myBook.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Book b2 = (Book) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println(b2);
    }
}
