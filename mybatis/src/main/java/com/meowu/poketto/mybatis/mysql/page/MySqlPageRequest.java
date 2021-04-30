package com.meowu.poketto.mybatis.mysql.page;

import com.meowu.poketto.commons.security.page.PageRequest;

public class MySqlPageRequest<T> extends PageRequest{

    public MySqlPageRequest(){
        super();
    }

    public MySqlPageRequest(Long pageNumber, Long pageSize){
        super(pageNumber, pageSize);
    }

    @Override
    public Long getOffset(){
        return (getPageNumber() - 1) * getPageSize();
    }
}
