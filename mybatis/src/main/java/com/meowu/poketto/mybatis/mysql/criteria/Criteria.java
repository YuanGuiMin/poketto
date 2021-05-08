package com.meowu.poketto.mybatis.mysql.criteria;

import com.google.common.collect.Lists;
import com.meowu.poketto.commons.utils.AssertUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Criteria{

    private List<Criterion> conditions = Lists.newArrayList();
    private List<Criterion> sort       = Lists.newArrayList();

    private Criterion limit;
    private Criterion groupBy;

    public Criteria(){

    }

    public Criteria add(Criterion condition){
        AssertUtils.notNull(condition, "condition must not be null");

        this.conditions.add(condition);

        return this;
    }

    public Criteria sort(Criterion sort){
        AssertUtils.notNull(sort, "sort condition must not be null");

        this.sort.add(sort);

        return this;
    }

    public Criteria limit(Criterion limit){
        AssertUtils.notNull(limit, "limit condition must not be null");

        this.limit = limit;

        return this;
    }

    public Criteria groupBy(Criterion groupBy){
        AssertUtils.notNull(groupBy, "group by condition must not be null");

        this.groupBy = groupBy;

        return this;
    }

    public Criteria clear(){
        this.conditions.clear();
        this.sort.clear();
        this.limit = null;
        this.groupBy = null;

        return this;
    }

    public Criteria clearCondition(){
        this.conditions.clear();

        return this;
    }

    public Criteria clearSort(){
        this.sort.clear();

        return this;
    }

    public Criteria clearLimit(){
        this.limit = null;

        return this;
    }

    public Criteria clearGroupBy(){
        this.groupBy = null;

        return this;
    }
}
