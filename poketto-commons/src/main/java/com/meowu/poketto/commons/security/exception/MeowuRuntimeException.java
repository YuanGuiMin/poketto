package com.meowu.poketto.commons.security.exception;

import java.text.MessageFormat;

public class MeowuRuntimeException extends RuntimeException{

    public MeowuRuntimeException(){
        super();
    }

    public MeowuRuntimeException(String message){
        super(message);
    }

    public MeowuRuntimeException(Throwable cause){
        super(cause);
    }

    public MeowuRuntimeException(String message, Throwable cause){
        super(message, cause);
    }

    public MeowuRuntimeException(String message, Object... args){
        super(MessageFormat.format(message, args));
    }

    public MeowuRuntimeException(Throwable cause, String message, Object... args){
        super(MessageFormat.format(message, args), cause);
    }
}
