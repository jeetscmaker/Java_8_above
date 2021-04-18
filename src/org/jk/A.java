package org.jk;

import java.math.BigInteger;

public class A {
    public static void main(String[] args) {
        int n = 50;
        BigInteger factorial = findFactorial(n);
        System.out.println(factorial);
    }

    private static BigInteger findFactorial(int n) {
        if (n > 50 || n < 0) {
            throw new RuntimeException("Input should not be greater than 20 and negative.");
        }
        if (n <= 1) {
            return BigInteger.ONE;
        }
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            result = result.multiply(new BigInteger(String.valueOf(i)));
        }
        return result;
    }
}
