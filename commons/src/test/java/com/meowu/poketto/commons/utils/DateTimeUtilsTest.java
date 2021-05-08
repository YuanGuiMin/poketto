package com.meowu.poketto.commons.utils;

import org.junit.Test;

import java.util.Date;

public class DateTimeUtilsTest{

    @Test
    public void format(){
        System.out.println(DateTimeUtils.format(new Date()));
    }

    @Test
    public void parse(){
        System.out.println(DateTimeUtils.parse("2021-05-08 14:49:07", "yyyy-MM-dd HH:mm:ss"));
    }

    @Test
    public void toDate(){
        System.out.println(DateTimeUtils.toDate(new Date(), "America/Nome"));
    }

    @Test
    public void convert(){
        System.out.println(DateTimeUtils.toDate(new Date(), "America/Nome", "Asia/Shanghai"));
    }

    @Test
    public void localTimeZoneID(){
        System.out.println(DateTimeUtils.localTimeZoneID());
    }
}
