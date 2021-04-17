package com.meowu.poketto.commons.security.exception;

import java.text.MessageFormat;

public class MeowuException extends Exception{

    public MeowuException(){
        super();
    }

    public MeowuException(String message){
        super(message);
    }

    public MeowuException(Throwable cause){
        super(cause);
    }

    public MeowuException(String message, Throwable cause){
        super(message, cause);
    }

    public MeowuException(String message, Object... args){
        super(MessageFormat.format(message, args));
    }

    public MeowuException(Throwable cause, String message, Object... args){
        super(MessageFormat.format(message, args), cause);
    }
}
