package com.meowu.poketto.commons.utils;

import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;

import java.util.Date;
import java.util.TimeZone;

public class DateTimeUtils{

    private static final String FULL_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static String format(Date date){
        return format(date, FULL_TIME_PATTERN);
    }

    public static String format(Date date, String pattern){
        AssertUtils.notNull(date, "the date object must not be null");
        AssertUtils.isNotBlank(pattern, "the format pattern must not be null");

        return new LocalDateTime(date).toString(pattern);
    }

    public static Date parse(String date, String pattern){
        AssertUtils.isNotBlank(date, "the date string must not be null");
        AssertUtils.isNotBlank(pattern, "the format pattern must not be null");

        return LocalDateTime.parse(date, DateTimeFormat.forPattern(pattern)).toDate();
    }

    public static Date toDate(Date date, String timeZone){
        AssertUtils.notNull(date, "the date object must not be null");
        AssertUtils.isNotBlank(timeZone, "the time zone to convert must not be null");

        return new LocalDateTime(date).toDate(TimeZone.getTimeZone(timeZone));
    }

    public static Date toDate(Date date, String locale, String convert){
        AssertUtils.notNull(date, "the date object must not be null");
        AssertUtils.isNotBlank(locale, "the local time zone to change must not be null");
        AssertUtils.isNotBlank(convert, "the time zone to convert must not be null");

        return new LocalDateTime(date, DateTimeZone.forID(locale)).toDate(TimeZone.getTimeZone(convert));
    }

    public static TimeZone localTimeZone(){
        return DateTimeZone.getDefault().toTimeZone();
    }

    public static String localTimeZoneID(){
        return localTimeZone().getID();
    }
}
