package com.meowu.poketto.commons.domain;

import com.meowu.poketto.commons.utils.GsonUtils;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

@Getter
@Setter
public class Entity{

    protected String id;

    @Override
    public boolean equals(Object compare){
        if(this == compare){
            return true;
        }

        if(this.getClass() == compare.getClass()){
            Entity entity = (Entity) compare;

            if(StringUtils.isNotBlank(this.id)){
                return this.id.equals(entity.id);
            }
        }

        return false;
    }

    @Override
    public int hashCode(){
        return StringUtils.isBlank(this.id) ? 0 : this.id.hashCode();
    }

    @Override
    public String toString(){
        return GsonUtils.serialize(this);
    }
}
