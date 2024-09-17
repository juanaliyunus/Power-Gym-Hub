package com.work.baseapp.exception.util;

public class ValidationException extends  RuntimeException{
    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }

}
