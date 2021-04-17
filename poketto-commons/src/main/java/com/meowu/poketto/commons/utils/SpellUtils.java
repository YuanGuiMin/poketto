package com.meowu.poketto.commons.utils;

import com.google.common.base.CaseFormat;
import org.apache.commons.lang3.StringUtils;

public class SpellUtils{

    public static String upper(String str){
        if(StringUtils.isBlank(str)){
            return str;
        }

        return str.toUpperCase();
    }

    public static String lower(String str){
        if(StringUtils.isBlank(str)){
            return str;
        }

        return str.toLowerCase();
    }

    public static String capitalize(String str){
        return StringUtils.capitalize(str);
    }

    public static String uncapitalize(String str){
        return StringUtils.uncapitalize(str);
    }

    public static String underline(String str){
        if(StringUtils.isBlank(str)){
            return str;
        }

        return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, str);
    }

    public static String camel(String str){
        if(StringUtils.isBlank(str)){
            return str;
        }

        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, str);
    }
}
