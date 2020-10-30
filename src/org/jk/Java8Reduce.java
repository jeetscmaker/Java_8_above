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

        /*To make the code even more concise, we can use a method reference, instead of a lambda expression:*/
        result = numbers.stream().reduce(0, Integer::sum);
        System.out.println("The result of 2nd reduce is: " + result);
    }
}
