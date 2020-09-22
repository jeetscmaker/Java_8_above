package org.jk;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Sam"));
        users.add(new User(4, "Joseph"));
        users.add(new User(6, "Robert"));
        users.add(new User(7, "Colin"));
        users.add(new User(11, "Danny"));
        users.add(new User(5, "Kristine"));

        System.out.println("Before sorting the list:");
        System.out.println(users);

        System.out.println("After sorting the list by Id:");
        Collections.sort(users, Comparator.comparing(User::getId));
        System.out.println(users);

        System.out.println("After sorting the list by name:");
        Collections.sort(users, Comparator.comparing(User::getName));
        System.out.println(users);
    }
}
