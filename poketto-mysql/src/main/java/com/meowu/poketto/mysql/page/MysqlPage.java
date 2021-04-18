package com.meowu.poketto.mysql.page;

import com.meowu.poketto.commons.security.page.Page;
import com.meowu.poketto.commons.security.page.PageRequest;

import java.util.List;

public class MysqlPage<T> extends Page<T>{

    public MysqlPage(List<T> content, Long total, PageRequest pageRequest){
        super(content, total, pageRequest);
    }

    @Override
    public boolean hasNext(){
        return getPageRequest().getOffset() + getContent().size() < getTotal();
    }
}
