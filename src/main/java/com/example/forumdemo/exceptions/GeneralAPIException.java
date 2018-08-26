package com.example.forumdemo.exceptions;

import com.example.forumdemo.model.web.ErrorResponse;
import org.springframework.http.HttpStatus;

public class GeneralAPIException extends AbstractAPIException {

    private static final String DEFAULT_MESSAGE = "Unexpected error occurred";

    public GeneralAPIException() {
    }

    public GeneralAPIException(String message) {
        super(message);
    }

    @Override
    public String getDefaultMessage() {
        return DEFAULT_MESSAGE;
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR; //500
    }

    @Override
    public ErrorResponse getErrorResponse() {
        return ErrorResponse.builder()
                .message(getDefaultMessage())
                .build();
    }
}
