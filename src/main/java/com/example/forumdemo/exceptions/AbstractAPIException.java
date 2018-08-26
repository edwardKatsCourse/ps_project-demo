package com.example.forumdemo.exceptions;

import com.example.forumdemo.model.web.ErrorResponse;
import org.springframework.http.HttpStatus;

public abstract class AbstractAPIException extends RuntimeException {


    public AbstractAPIException() {
    }

    public AbstractAPIException(String message) {
        super(message);
    }

    public abstract String getDefaultMessage();
    public abstract HttpStatus getStatus();
    public abstract ErrorResponse getErrorResponse();
}
