package com.meowu.poketto.commons.domain;

public interface Sortable extends Comparable{

    Integer getOrder();

    void setOrder(Integer order);
}
