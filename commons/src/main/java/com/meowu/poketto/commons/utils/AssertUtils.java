package com.meowu.poketto.commons.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.Collection;

public class AssertUtils{

    public static void notNull(Object object, String message){
        if(object == null){
            throw new IllegalArgumentException(message);
        }
    }

    public static void isNotBlank(String str, String message){
        if(StringUtils.isBlank(str)){
            throw new IllegalArgumentException(message);
        }
    }

    public static void isNotEmpty(Collection collection, String message){
        if(collection == null || collection.isEmpty()){
            throw new IllegalArgumentException(message);
        }
    }

    public static <T> void isNotEmpty(T[] array, String message){
        if(array == null || array.length == 0){
            throw new IllegalArgumentException(message);
        }
    }
}
