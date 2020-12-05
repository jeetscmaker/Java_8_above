package org.jk.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Test the features of LocalDate class from Java 8.
 * */
public class LocalDateTest {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        System.out.println(LocalDate.parse("2015-02-20"));
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        System.out.println(tomorrow);
        LocalDate previousMonthSameDay = LocalDate.now().minus(1, ChronoUnit.MONTHS);
        System.out.println(previousMonthSameDay);
        DayOfWeek sunday = LocalDate.parse("2016-06-12").getDayOfWeek();
        System.out.println(sunday);
        int twelve = LocalDate.parse("2016-06-12").getDayOfMonth();
        System.out.println(twelve);
        //We can test if a date occurs in a leap year. In this example we test if the current date occurs is a leap year:
        System.out.println(LocalDate.now().isLeapYear());
    }
}
