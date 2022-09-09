package Java8_pkg;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

public class java8pkg {
}

class DateTime{

    public static void content(){
        //  ISO 8001 日期時間
        //  LocalDate 無時間 無時區概念
        LocalDate _nowD = LocalDate.now();
        LocalDate date = LocalDate.of(1995, 5, 23);
        date.isBefore(_nowD); date.isLeapYear();
        date.getDayOfWeek(); date.getDayOfMonth(); date.getDayOfYear();
        date.plusMonths(1); date.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        LocalDate.of(1995, Month.MAY, 23);

        LocalTime nowT = LocalTime.now();
        nowT.plusHours(1).plusMinutes(35);
        nowT.truncatedTo(ChronoUnit.MINUTES);
        nowT.toSecondOfDay();//一天秒數
        LocalTime lunch = LocalTime.of(12, 5);
        lunch.isBefore(nowT);
        nowT.until(lunch, ChronoUnit.MINUTES); nowT.until(lunch, ChronoUnit.HOURS);

        LocalDateTime flight = LocalDateTime.of(_nowD, nowT);
        LocalDateTime dt = LocalDateTime.of(2016, Month.MAY, 2, 9, 30);
        dt.plusDays(2).plusHours(3);

        long days = ChronoUnit.DAYS.between(_nowD, date);
        Period p = Period.between(_nowD, date);
        p.getMonths(); p.getDays();
        dt.plus(p);
        p = Period.ofMonths(1).ofDays(1);

        var formatter1 = DateTimeFormatter.ISO_DATE;
        formatter1 = DateTimeFormatter.ISO_DATE_TIME;
        formatter1 = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        formatter1 = DateTimeFormatter.ISO_ORDINAL_DATE;
        formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.n");

        //   星期三, 三月 23, 2016 西元, 11:20 上午
        formatter1 = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy H, hh:mm a");
        formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        System.out.println(nowT.format(formatter1));

        formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.n");
        LocalDate d = LocalDate.parse("2016-05-25 13:12:25.3", formatter1);





    }



}
