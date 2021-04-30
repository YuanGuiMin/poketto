package com.meowu.poketto.commons.domain;

import java.util.Date;

public interface Updatable{

    Date getUpdateTime();

    void setUpdateTime(Date updateTime);
}
