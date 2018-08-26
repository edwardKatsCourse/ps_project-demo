package com.example.forumdemo.exceptions;


import org.springframework.http.HttpStatus;

public class UserDuplicationException extends GeneralAPIException {

    private static final String DEFAULT_MESSAGE = "User with such username [%s] already exists";

    private String username;

    public UserDuplicationException(String username) {
        this.username = username;
    }

    @Override
    public String getDefaultMessage() {
        return String.format(DEFAULT_MESSAGE, this.username);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.CONFLICT;
    }
}
