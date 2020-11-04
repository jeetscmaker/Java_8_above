package org.jk;

import java.util.Optional;

/**
 * Java 8 Optional class examples under various scenarios.
 */

public class OptionalEx {
    public static void main(String[] args) {
        //To create an empty Optional object, we simply need to use its empty() static method:
        /* we used the isPresent() method to check if there is a value inside the Optional
        object. A value is present only if we have created Optional with a non-null value. */
        Optional<String> empty = Optional.empty();
        System.out.println(empty.isPresent());

        //We can also create an Optional object with the static method of():
        String name = "John";
        Optional<String> opt = Optional.of(name);
        System.out.println(opt.isPresent());

        //However, the argument passed to the of() method can't be null. Otherwise,
        // we'll get a NullPointerException:
        name = null;
        System.out.println(Optional.of(name).isPresent()); // will throw NPE.

    }
}
