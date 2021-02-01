package org.jk.generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenericsTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        printList(list);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);
        printList(list2);
        Number numberInt = 11;
        Number numberFloat = 11.5f;
        Number numberDouble = 12.55;
        Number numberLong = 14L;
        List<Number> numbers = new ArrayList<>();
        numbers.add(numberInt);
        numbers.add(numberFloat);
        numbers.add(numberDouble);
        numbers.add(numberLong);

    }

    private static <T> void printList(List<T> list) {
        Iterator<T> itr = list.iterator();
        while (itr.hasNext()){
            System.out.print(itr.next() + " ");
        }
    }

    /*private static <Number> void printSum(List<Number> list) {
        Iterator itr = list.iterator();
        Number sum = 0;
        while (itr.hasNext()){
            sum = sum + itr.next();
        }
    }*/
}
