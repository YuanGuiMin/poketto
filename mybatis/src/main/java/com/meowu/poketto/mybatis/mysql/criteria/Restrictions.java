package com.meowu.poketto.mybatis.mysql.criteria;

import com.meowu.poketto.commons.utils.AssertUtils;
import com.meowu.poketto.commons.utils.SpellUtils;
import com.meowu.poketto.mybatis.mysql.page.MySqlPageRequest;

import java.util.Arrays;
import java.util.List;

public class Restrictions{

    public static Criterion eq(String field, Object value){
        return new Criterion(getField(field)).eq(value);
    }

    public static Criterion ne(String field, Object value){
        return new Criterion(getField(field)).ne(value);
    }

    public static Criterion lt(String field, Object value){
        return new Criterion(getField(field)).lt(value);
    }

    public static Criterion le(String field, Object value){
        return new Criterion(getField(field)).le(value);
    }

    public static Criterion gt(String field, Object value){
        return new Criterion(getField(field)).gt(value);
    }

    public static Criterion ge(String field, Object value){
        return new Criterion(getField(field)).ge(value);
    }

    public static Criterion like(String field, Object value){
        return new Criterion(getField(field)).like("%" + value + "%");
    }

    public static Criterion notLike(String field, Object value){
        return new Criterion(getField(field)).notLike("%" + value + "%");
    }

    public static Criterion between(String field, Object first, Object second){
        return new Criterion(getField(field)).between(first, second);
    }

    public static Criterion notBetween(String field, Object first, Object second){
        return new Criterion(getField(field)).notBetween(first, second);
    }

    public static Criterion in(String field, List<Object> value){
        return new Criterion(getField(field)).in(value);
    }

    public static Criterion notIn(String field, List<Object> value){
        return new Criterion(getField(field)).notIn(value);
    }

    public static Criterion regexp(String field, Object value){
        return new Criterion(getField(field)).regexp(value);
    }

    public static Criterion isNull(String field){
        return new Criterion(getField(field)).isNull();
    }

    public static Criterion notNull(String field){
        return new Criterion(getField(field)).notNull();
    }

    public static Criterion and(Criterion... criteria){
        return new Criterion().and(criteria);
    }

    public static Criterion or(Criterion... criteria){
        return new Criterion().or(criteria);
    }

    public static Criterion limit(MySqlPageRequest pageRequest){
        return new Criterion().limit(pageRequest.getOffset(), pageRequest.getPageSize());
    }

    public static Criterion asc(String... fields){
        return new Criterion(getFields(fields)).asc();
    }

    public static Criterion desc(String... fields){
        return new Criterion(getFields(fields)).desc();
    }

    private static String getField(String field){
        AssertUtils.isNotBlank(field, "computed field must not be null");

        return SpellUtils.underline(field);
    }

    private static String[] getFields(String... fields){
        AssertUtils.isNotEmpty(fields, "computed fields must not be null");

        return Arrays.stream(fields)
                     .map(field -> getField(field))
                     .toArray(String[]::new);
    }
}
