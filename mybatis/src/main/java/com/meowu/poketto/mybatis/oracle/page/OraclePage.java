package com.meowu.poketto.mybatis.oracle.page;

import com.meowu.poketto.commons.security.page.Page;
import com.meowu.poketto.commons.security.page.PageRequest;

import java.util.List;

public class OraclePage<T> extends Page{

    public OraclePage(List<T> content, Long total, PageRequest pageRequest){
        super(content, total, pageRequest);
    }

    @Override
    public boolean hasNext(){
        return getPageRequest().getOffset() + getContent().size() - 1 < getTotal();
    }
}
