package com.meowu.poketto.commons.security.page;

import lombok.Getter;

@Getter
public abstract class PageRequest{

    private transient long PAGE_NUMBER = 1L;
    private transient long PAGE_SIZE   = 20L;

    private Long pageNumber;
    private Long pageSize;

    public PageRequest(){
        this.pageNumber = PAGE_NUMBER;
        this.pageSize   = PAGE_SIZE;
    }

    public PageRequest(Long pageNumber, Long pageSize){
        this.pageNumber = (pageNumber == null || pageNumber < 1) ? PAGE_NUMBER : pageNumber;
        this.pageSize   = (pageSize   == null || pageSize < 0)   ? PAGE_SIZE   : pageSize;
    }

    public abstract Long getOffset();
}
