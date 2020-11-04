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
        //System.out.println(Optional.of(name).isPresent()); // will throw NPE.

        //The orElse() method is used to retrieve the value wrapped inside an
        // Optional instance. It takes one parameter, which acts as a default
        // value. The orElse() method returns the wrapped value if it's present,
        // and its argument otherwise:
        String nullName = null;
        String _name = Optional.ofNullable(nullName).orElse("john");
        System.out.println(_name);

        //The orElseGet() method is similar to orElse(). However, instead of
        // taking a value to return if the Optional value is not present, it
        // takes a supplier functional interface, which is invoked and returns
        // the value of the invocation:
        _name = Optional.ofNullable(nullName).orElseGet(() -> "Bond");
        System.out.println(_name);

        //The orElseThrow() method follows from orElse() and orElseGet() and
        // adds a new approach for handling an absent value.
        _name = Optional.ofNullable(nullName).orElseThrow(
                IllegalArgumentException::new);
        //Java 10 introduced a simplified no-arg version of orElseThrow() method.
        // In case of an empty Optional it throws a NoSuchElementException:
        _name = Optional.ofNullable(nullName).orElseThrow();

        // Optional get() method, not advisable to use.
        System.out.println(Optional.of("Jane").get());
    }
}
