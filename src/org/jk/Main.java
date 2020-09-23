package org.jk;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Sam", 3000));
        users.add(new User(4, "Joseph", 3500));
        users.add(new User(6, "Robert", 2900));
        users.add(new User(3, "Robert", 4000));
        users.add(new User(7, "Colin", 3800));
        users.add(new User(11, "Danny", 4500));
        users.add(new User(9, "Danny", 2800));
        users.add(new User(5, "Kristine", 2900));
        users.add(new User(16, "Robert", 3500));
        System.out.println("Before sorting the list:");
        System.out.println(users);

        System.out.println("After sorting the list by Id:");
        Collections.sort(users, Comparator.comparing(User::getId));
        System.out.println(users);

        // overriding the default comparison by providing custom comparator.
        Comparator<User> comparator = Comparator.comparing(User::getId, Comparator.reverseOrder());
        System.out.println("After custom comparator, descending order of id:");
        Collections.sort(users, comparator);
        System.out.println(users);

        /* suppose we have a requirement that sort the users by name and if the names are same
         * then sort by id without breaking the sorting by name. For example {6, Robert} and {3, Robert}
         * should be in the order {3, Robert}, {6, Robert}. */
        Collections.sort(users, Comparator.comparing(User::getName));
        System.out.println(users);

        Optional<User> x = users.stream().collect(Collectors.maxBy(Comparator.comparing(User::getSalary)));
        System.out.println(x.get());
        //-----------------------------------------------------------//
        int[][] arr = {{1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10}};
        Arrays.stream(arr).flatMap(a -> Arrays.stream(a).boxed()).forEach(p->System.out.print(p + " "));
    }
}
