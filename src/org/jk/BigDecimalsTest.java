package org.jk;

import java.math.BigDecimal;

public class BigDecimalsTest {
    public static void main(String[] args) {
        BigDecimal sum = new BigDecimal("0");
        BigDecimal avg;
        BigDecimal[] arr = {
                new BigDecimal("12.0"),
                new BigDecimal("115.0"),
                new BigDecimal("67.0"),
                new BigDecimal("42.0")
        };
        for (int i = 0; i < arr.length; i++) {
            sum = sum.add(arr[i]);
        }
        avg = sum.divide(new BigDecimal(arr.length));
        System.out.println("The average is: " + avg);
    }
}
