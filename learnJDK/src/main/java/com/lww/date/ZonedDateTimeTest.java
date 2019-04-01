package com.lww.date;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class ZonedDateTimeTest {
    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now();
        LocalDate localDate = now.toLocalDate();
        LocalDateTime localDateTime = now.toLocalDateTime();
        LocalTime localTime = now.toLocalTime();


        ZoneId zone1 = ZoneId.of("GMT-09:00");
        ZoneId zone2 = ZoneId.of("Asia/Shanghai");

        LocalDate date1 = LocalDate.now(zone1);
        LocalDate date2 = LocalDate.now(zone2);

        LocalTime.now();
        LocalTime time1 = LocalTime.now(zone1);
        LocalTime time2 = LocalTime.now(zone2);






    }
}
