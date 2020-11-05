package org.jk;

import java.util.Arrays;
import java.util.List;
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
//        _name = Optional.ofNullable(nullName).orElseThrow(
//                IllegalArgumentException::new);
        //Java 10 introduced a simplified no-arg version of orElseThrow() method.
        // In case of an empty Optional it throws a NoSuchElementException:
//        _name = Optional.ofNullable(nullName).orElseThrow();

        // Optional get() method, not advisable to use.
        System.out.println(Optional.of("Jane").get());

        //We can run an inline test on our wrapped value with the filter method.
        // It takes a predicate as an argument and returns an Optional object.
        // If the wrapped value passes testing by the predicate, then the Optional is returned as-is.
        // However, if the predicate returns false, then it will return an empty Optional:
        Integer year = 2016;
        Optional<Integer> yearOptional = Optional.of(year);
        boolean is2016 = yearOptional.filter(y -> y == 2016).isPresent();
        System.out.println(is2016);
        boolean is2017 = yearOptional.filter(y -> y == 2017).isPresent();
        System.out.println(is2017);

        //We can use a similar syntax to transform the Optional value with the map() method:
        List<String> companyNames = Arrays.asList(
                "paypal", "oracle", "", "microsoft", "", "apple");
        Optional<List<String>> listOptional = Optional.of(companyNames);

        int size = listOptional
                .map(List::size)
                .orElse(0);
        System.out.println(size);

        // FlatMap() in Optional
        Person person = new Person("john", 26);
        Optional<Person> personOptional = Optional.of(person);

        Optional<Optional<String>> nameOptionalWrapper
                = personOptional.map(Person::getName);
        Optional<String> nameOptional
                = nameOptionalWrapper.orElseThrow(IllegalArgumentException::new);
        String name1 = nameOptional.orElse("");
        System.out.println(name1);

        name1 = personOptional
                .flatMap(Person::getName)
                .orElse("");
        System.out.println(name1);
    }
}

class Person {
    private String name;
    private int age;
    private String password;

    Person(String n, int a) {
        name = n;
        age = a;
    }

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    public Optional<Integer> getAge() {
        return Optional.ofNullable(age);
    }

    public Optional<String> getPassword() {
        return Optional.ofNullable(password);
    }

    // normal constructors and setters
}
