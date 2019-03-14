package com.lww.learnjdk.Time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.TimeZone;

public class CalendarTest {
    public static void main(String[] args) {
//        String[] ids = TimeZone.getAvailableIDs();
//        for (String id:ids)
//            System.out.printf(id+", ");

        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("GMT-09:00"));
        System.out.println(localDateTime.getHour());
        System.out.println(localDateTime.toString());

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(localDateTime.format(dateTimeFormatter));

        LocalDate localDate = LocalDate.now();

        System.out.println(localDate.toString());



        Calendar calendar1 = Calendar.getInstance();

        TimeZone timeZone2 = TimeZone.getTimeZone("GMT-9:00");
        Calendar calendar2 = Calendar.getInstance(timeZone2);


        TimeZone timeZone3 = TimeZone.getTimeZone("GMT+09:00");
        Calendar calendar3 = Calendar.getInstance(timeZone3);

        System.out.println(calendar1.getTime());
        System.out.println("day:" + calendar1.get(Calendar.DATE) + ""
                + "time:" + calendar1.get(Calendar.HOUR_OF_DAY) + ""
                + "hour:" + calendar1.get(Calendar.HOUR) + ""
                + "PM:" + calendar1.get(Calendar.AM_PM));

        System.out.println(calendar2.getTime());
        System.out.println("day:" + calendar2.get(Calendar.DATE) + ""
                + "time:" + calendar2.get(Calendar.HOUR_OF_DAY) + ""
                + "hour:" + calendar2.get(Calendar.HOUR) + ""
                + "PM:" + calendar2.get(Calendar.AM_PM));

        System.out.println(calendar3.getTime());
        System.out.println("day:" + calendar3.get(Calendar.DATE) + ""
                + "time:" + calendar3.get(Calendar.HOUR_OF_DAY) + ""
                + "hour:" + calendar3.get(Calendar.HOUR) + ""
                + "PM:" + calendar3.get(Calendar.AM_PM));

    }
}
