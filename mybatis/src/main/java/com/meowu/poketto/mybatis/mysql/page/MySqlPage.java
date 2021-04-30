package com.meowu.poketto.mybatis.mysql.page;

import com.meowu.poketto.commons.security.page.Page;
import com.meowu.poketto.commons.security.page.PageRequest;

import java.util.List;

public class MySqlPage<T> extends Page{

    public MySqlPage(List<T> content, Long total, PageRequest pageRequest){
        super(content, total, pageRequest);
    }

    @Override
    public boolean hasNext(){
        return getPageRequest().getOffset() + getContent().size() < getTotal();
    }
}
