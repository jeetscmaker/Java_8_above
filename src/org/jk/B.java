package org.jk;

import java.io.FileNotFoundException;
import java.nio.file.NoSuchFileException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jitendra
 * The hash calculation is the most important part in a hashMap. What object we
 * are going to get through get() method totally depends on the hash calculation.
 * Look at the below examples for more.
 */
public class B {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        Map<User, String> map2 = new HashMap<>();
        map.put("name", "John");
        System.out.println("Name: " + map.get(new String("name")));

        User u1 = new User(1, "A", 10.0);
        map2.put(u1, "Andrew");
        u1 = new User(2, "B", 20.0);
        System.out.println("The user is: " + map2.get(u1));

        u1 = new User(1, "A", 10.0);
        System.out.println("The user is: " + map2.get(u1));
    }
}

/* A child class method which overrides a method from parent class, is allowed to throw
 * an exception which is either equal to or a subclass of the exception which the parent
 * method throws. For example if m1() in parent throws FileNotFoundException, then m1()
 * in child class cannot throw 'Exception'. But vice versa is allowed. This rule is applicable
 * only in case of "Checked Exceptions".
 * For RuntimeExceptions aka "Unchecked Exceptions", the above rule doesn't apply.
 */
class B1 {
    public void m1() throws Exception {
        System.out.println("Throwing Exception");
    }
}

class B2 extends B1 {
    public void m1() throws NoSuchFileException {
        System.out.println("Throwing NoSuchFileException");
    }
}
