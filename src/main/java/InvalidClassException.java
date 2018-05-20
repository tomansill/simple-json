package com.simplejson;

public class InvalidClassException extends RuntimeException{

    public InvalidClassException(){
        super();
    }

    public InvalidClassException(String message){
        super(message);
    }

    public InvalidClassException(String message, Throwable cause){
        super(message, cause);
    }

    public InvalidClassException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public InvalidClassException(Throwable cause){
        super(cause);
    }
}
