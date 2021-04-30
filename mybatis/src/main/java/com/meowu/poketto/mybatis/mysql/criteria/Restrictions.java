package com.meowu.poketto.mybatis.mysql.criteria;

import com.meowu.poketto.commons.utils.AssertUtils;
import com.meowu.poketto.commons.utils.SpellUtils;

public class Restrictions{

    public static Criterion eq(String property, Object value){
        return new Criterion(getProperty(property)).eq(value);
    }

    public static Criterion ne(String property, Object value){
        return new Criterion(getProperty(property)).ne(value);
    }

    public static Criterion lt(String property, Object value){
        return new Criterion(getProperty(property)).lt(value);
    }

    public static Criterion le(String property, Object value){
        return new Criterion(getProperty(property)).le(value);
    }

    public static Criterion gt(String property, Object value){
        return new Criterion(getProperty(property)).gt(value);
    }

    public static Criterion ge(String property, Object value){
        return new Criterion(getProperty(property)).ge(value);
    }

    public static Criterion like(String property, Object value){
        return new Criterion(getProperty(property)).like("%" + value + "%");
    }

    public static Criterion notLike(String property, Object value){
        return new Criterion(getProperty(property)).notLike("%" + value + "%");
    }

    public static Criterion between(String property, Object first, Object second){
        return new Criterion(getProperty(property)).between(first, second);
    }

    public static Criterion notBetween(String property, Object first, Object second){
        return new Criterion(getProperty(property)).notBetween(first, second);
    }

    private static String getProperty(String property){
        AssertUtils.isNotBlank(property, "computed property must not be null");

        return SpellUtils.underline(property);
    }
}
