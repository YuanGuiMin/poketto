package com.meowu.poketto.mybatis.oracle.page;

import com.meowu.poketto.commons.security.page.PageRequest;

public class OraclePageRequest<T> extends PageRequest{

    public OraclePageRequest(){
        super();
    }

    public OraclePageRequest(Long pageNumber, Long pageSize){
        super(pageNumber, pageSize);
    }

    @Override
    public Long getOffset(){
        return (getPageNumber() - 1) * getPageSize() + 1;
    }
}
