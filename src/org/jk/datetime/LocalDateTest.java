package org.jk.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 * Test the features of LocalDate class from Java 8.
 */
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

        //The relationship of a date to another can be determined to occur before or after another date:
        boolean notBefore = LocalDate.parse("2016-06-12")
                .isBefore(LocalDate.parse("2016-06-11"));
        System.out.println(notBefore);
        boolean isAfter = LocalDate.parse("2016-06-12")
                .isAfter(LocalDate.parse("2016-06-11"));
        System.out.println(isAfter);

       /* Date boundaries can be obtained from a given date. In the following two examples we get the
        LocalDateTime that represents the beginning of the day (2016-06-12T00:00) of the given date
        and the LocalDate that represents the beginning of the month (2016-06-01) respectively:
        */
        LocalDateTime beginningOfDay = LocalDate.parse("2016-06-12").atStartOfDay();
        LocalDate firstDayOfMonth = LocalDate.parse("2016-06-12")
                .with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(beginningOfDay);
        System.out.println(firstDayOfMonth);
    }
}
