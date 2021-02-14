package org.jk;

import java.nio.charset.Charset;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        //string will not be anything remotely alphanumeric.
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        System.out.println(generatedString);
    }
}
