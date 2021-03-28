package org.jk;

import java.util.stream.IntStream;

public class ParallelStreams {
    public static void main(String[] args) {
        IntStream intStream = IntStream.range(1, 100000);
        long start = System.currentTimeMillis();
        long k = intStream.map(i -> i * 2).count();
        long end = System.currentTimeMillis();
        System.out.println("The normal stream takes " + (end-start) + " milliseconds.");

        System.out.println("==========================================");

        IntStream parallelStream = IntStream.range(1, 100000).parallel();
        start = System.currentTimeMillis();
        k = parallelStream.map(i -> i * 2).count();
        end = System.currentTimeMillis();
        System.out.println("The parallel stream takes " + (end-start) + " milliseconds.");
    }
}
