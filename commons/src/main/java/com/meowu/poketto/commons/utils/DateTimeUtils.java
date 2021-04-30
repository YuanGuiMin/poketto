package com.meowu.poketto.commons.utils;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.util.Date;

public class DateTimeUtils{

    private static final String FULL_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static String toString(Date date){
        return toString(date, FULL_TIME_PATTERN);
    }

    public static String toString(Date date, String pattern){
        AssertUtils.notNull(date, "the date to format must not be null");
        AssertUtils.isNotBlank(pattern, "the format pattern must not be null");

        return new DateTime(date).toString(pattern);
    }

    public static Date parse(String date, String pattern){
        AssertUtils.isNotBlank(date, "the date string must not be null");
        AssertUtils.isNotBlank(pattern, "then format pattern must not be null");

        return DateTime.parse(date, DateTimeFormat.forPattern(pattern)).toDate();
    }
}
