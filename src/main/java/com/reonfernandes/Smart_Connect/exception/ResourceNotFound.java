package com.reonfernandes.Smart_Connect.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class ResourceNotFound extends RuntimeException{
    public ResourceNotFound() {
    }

    public ResourceNotFound(String message) {
        super(message);
    }

    public ResourceNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceNotFound(Throwable cause) {
        super(cause);
    }

    public ResourceNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
