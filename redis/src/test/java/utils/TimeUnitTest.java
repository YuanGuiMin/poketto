package utils;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class TimeUnitTest{

    @Test
    public void convert(){
        System.out.println(TimeUnit.DAYS.toSeconds(1));
    }
}
