package com.meowu.poketto.commons.security.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response<T>{

    private transient int SUCCESS_CODE = 200;
    private transient int FAILURE_CODE = 500;

    private int     code;
    private String  msg;
    private Boolean success;
    private T       data;

    public Response(){
        this.code    = SUCCESS_CODE;
        this.success = true;
    }

    public Response(String msg){
        this.code    = SUCCESS_CODE;
        this.msg     = msg;
        this.success = true;
    }

    public Response(String msg, T data){
        this.code    = SUCCESS_CODE;
        this.msg     = msg;
        this.success = true;
        this.data    = data;
    }

    public Response(int code, String msg, boolean success){
        this.code    = code;
        this.msg     = msg;
        this.success = success;
    }

    public Response(int code, String msg, boolean success, T data){
        this.code    = code;
        this.msg     = msg;
        this.success = success;
        this.data    = data;
    }

    public Response failure(int code){
        this.code    = code;
        this.success = false;

        return this;
    }

    public Response failure(String msg){
        this.code    = FAILURE_CODE;
        this.msg     = msg;
        this.success = false;

        return this;
    }

    public Response failure(int code, String msg){
        this.code    = code;
        this.msg     = msg;
        this.success = false;

        return this;
    }
}

