package com.meowu.poketto.mybatis.mysql.criteria;

public interface Operator{

    String EQUAL       = "=";
    String NOT_EQUAL   = "<>";
    String LESS_THAN   = "<";
    String LESS_EQUAL  = "<=";
    String GREAT_THAN  = ">";
    String GREAT_EQUAL = ">=";
    String LIKE        = "LIKE";
    String NOT_LIKE    = "NOT LIKE";
    String BETWEEN     = "BETWEEN";
    String NOT_BETWEEN = "NOT BETWEEN";
    String IN          = "IN";
    String NOT_IN      = "NOT IN";
    String IS_NULL     = "IS NULL";
    String IS_NOT_NULL = "IS NOT NULL";
    String REGEXP      = "REGEXP";
    String AND         = "AND";
    String OR          = "OR";
    String LIMIT       = "LIMIT";
}
