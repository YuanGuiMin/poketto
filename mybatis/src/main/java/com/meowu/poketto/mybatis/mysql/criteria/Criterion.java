package com.meowu.poketto.mybatis.mysql.criteria;

import com.google.common.base.Joiner;
import com.meowu.poketto.commons.utils.AssertUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Criterion{

    private String field;
    private String operator;
    private Object value;
    private Object secondValue;

    //运算值类型
    private Boolean singleValue    = false;
    private Boolean twinValue      = false;
    private Boolean listValue      = false;
    private Boolean noValue        = false;
    private Boolean criterionValue = false;
    private Boolean limitValue     = false;
    private Boolean sortValue      = false;
    private Boolean groupByValue   = false;

    public Criterion(){

    }

    public Criterion(String field){
        this.field = field;
    }

    public Criterion(String... fields){
        this.field = Joiner.on(",").join(fields);
    }

    public Criterion eq(Object value){
        AssertUtils.notNull(value, "computed value must not be null");

        this.value       = value;
        this.operator    = Operator.EQUAL;
        this.singleValue = true;

        return this;
    }

    public Criterion ne(Object value){
        AssertUtils.notNull(value, "computed value must not be null");

        this.value       = value;
        this.operator    = Operator.NOT_EQUAL;
        this.singleValue = true;

        return this;
    }

    public Criterion lt(Object value){
        AssertUtils.notNull(value, "computed value must not be null");

        this.value       = value;
        this.operator    = Operator.LESS_THAN;
        this.singleValue = true;

        return this;
    }

    public Criterion le(Object value){
        AssertUtils.notNull(value, "computed value must not be null");

        this.value       = value;
        this.operator    = Operator.LESS_EQUAL;
        this.singleValue = true;

        return this;
    }

    public Criterion gt(Object value){
        AssertUtils.notNull(value, "computed value must not be null");

        this.value       = value;
        this.operator    = Operator.GREAT_THAN;
        this.singleValue = true;

        return this;
    }

    public Criterion ge(Object value){
        AssertUtils.notNull(value, "computed value must not be null");

        this.value       = value;
        this.operator    = Operator.GREAT_EQUAL;
        this.singleValue = true;

        return this;
    }

    public Criterion like(Object value){
        AssertUtils.notNull(value, "computed value must not be null");

        this.value       = value;
        this.operator    = Operator.LIKE;
        this.singleValue = true;

        return this;
    }

    public Criterion notLike(Object value){
        AssertUtils.notNull(value, "computed value must not be null");

        this.value       = value;
        this.operator    = Operator.NOT_LIKE;
        this.singleValue = true;

        return this;
    }

    public Criterion between(Object first, Object second){
        AssertUtils.notNull(first, "the first computed value must not be null");
        AssertUtils.notNull(second, "the second computed value must not be null");

        this.value       = first;
        this.secondValue = second;
        this.operator    = Operator.BETWEEN;
        this.twinValue   = true;

        return this;
    }

    public Criterion notBetween(Object first, Object second){
        AssertUtils.notNull(first, "the first computed value must not be null");
        AssertUtils.notNull(second, "the second computed value must not be null");

        this.value       = first;
        this.secondValue = second;
        this.operator    = Operator.NOT_BETWEEN;
        this.twinValue   = true;

        return this;
    }

    public Criterion in(List<Object> value){
        AssertUtils.isNotEmpty(value, "computed values must not be null");

        this.value     = value;
        this.operator  = Operator.IN;
        this.listValue = true;

        return this;
    }

    public Criterion notIn(List<Object> value){
        AssertUtils.isNotEmpty(value, "computed values must not be null");

        this.value     = value;
        this.operator  = Operator.NOT_IN;
        this.listValue = true;

        return this;
    }

    public Criterion regexp(Object value){
        AssertUtils.notNull(value, "computed value must not be null");

        this.value       = value;
        this.operator    = Operator.REGEXP;
        this.singleValue = true;

        return this;
    }

    public Criterion isNull(){
        this.operator = Operator.IS_NULL;
        this.noValue  = true;

        return this;
    }

    public Criterion notNull(){
        this.operator = Operator.IS_NOT_NULL;
        this.noValue  = true;

        return this;
    }

    public Criterion and(Criterion... criteria){
        AssertUtils.isNotEmpty(criteria, "computed values must not be null");

        this.value          = criteria;
        this.operator       = Operator.AND;
        this.criterionValue = true;

        return this;
    }

    public Criterion or(Criterion... criteria){
        AssertUtils.isNotEmpty(criteria, "computed values must not be null");

        this.value          = criteria;
        this.operator       = Operator.OR;
        this.criterionValue = true;

        return this;
    }

    public Criterion limit(Long offset, Long size){
        AssertUtils.notNull(offset, "offset number must not be null");
        AssertUtils.notNull(size, "size number must not be null");

        this.value       = offset;
        this.secondValue = size;
        this.operator    = Operator.LIMIT;
        this.limitValue  = true;

        return this;
    }

    public Criterion groupBy(){
        this.operator     = Operator.GROUP_BY;
        this.groupByValue = true;

        return this;
    }

    public Criterion asc(){
        this.value     = Operator.ASC;
        this.operator  = Operator.SORT;
        this.sortValue = true;

        return this;
    }

    public Criterion desc(){
        this.value     = Operator.DESC;
        this.operator  = Operator.SORT;
        this.sortValue = true;

        return this;
    }
}
