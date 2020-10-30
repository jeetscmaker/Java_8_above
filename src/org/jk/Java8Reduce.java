package org.jk;

import java.util.Arrays;
import java.util.List;

/**
 * @author Jitendra
 * The various usages of reduce() in stream API.
 */
public class Java8Reduce {
    public static void main(String[] args) {
        /**
         *
         -> Identity – an element that is the initial value of the reduction operation and the
         default result if the stream is empty.
         -> Accumulator – a function that takes two parameters: a partial result of the reduction
         operation and the next element of the stream.
         -> Combiner – a function used to combine the partial result of the reduction operation
         when the reduction is parallelized, or when there's a mismatch between the types of
         the accumulator arguments and the types of the accumulator implementation.
         * */
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int result = numbers
                .stream()
                .reduce(0, (subtotal, element) -> subtotal + element);
        System.out.println("The result of 1st reduce is: " + result);

        /* To make the code even more concise, we can use a method reference, instead of a lambda expression: */
        result = numbers.stream().reduce(0, Integer::sum);
        System.out.println("The result of 2nd reduce is: " + result);

        /* we can use reduce() on an array of String elements and join them into a single result: */
        List<String> letters = Arrays.asList("a", "b", "c", "d", "e");
        String s_result = letters
                .stream()
                .reduce("", (partialString, element) -> partialString + element);
        System.out.println("Result of string concatenation is: " + s_result);

        /**
         * In addition, we can use reduce() in a parallelized stream
         * When a stream executes in parallel, the Java runtime splits the stream
         * into multiple sub-streams. In such cases, we need to use a function to
         * combine the results of the sub-streams into a single one. This is the role
         * of the combiner – in the below snippet, it's the Integer::sum method reference.
         * */
        List<Integer> ages = Arrays.asList(25, 30, 45, 28, 32);
        int computedAges = ages.parallelStream().reduce(0, (a, b) -> (a + b), Integer::sum);
        System.out.println("Computed ages: " + computedAges);
    }
}
