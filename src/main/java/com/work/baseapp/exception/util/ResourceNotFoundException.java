package com.work.baseapp.exception.util;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
