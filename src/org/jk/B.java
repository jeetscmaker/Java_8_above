package org.jk;

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
    }
}
