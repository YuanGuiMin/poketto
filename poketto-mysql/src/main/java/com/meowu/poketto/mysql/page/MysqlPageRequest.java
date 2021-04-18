package com.meowu.poketto.mysql.page;

import com.meowu.poketto.commons.security.page.PageRequest;

public class MysqlPageRequest extends PageRequest{

    public MysqlPageRequest(){
        super();
    }

    public MysqlPageRequest(Long pageNumber, Long pageSize){
        super(pageNumber, pageSize);
    }

    @Override
    public Long getOffset(){
        return (getPageNumber() - 1) * getPageSize();
    }
}
