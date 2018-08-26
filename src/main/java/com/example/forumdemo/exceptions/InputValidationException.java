package com.example.forumdemo.exceptions;

import com.example.forumdemo.model.web.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InputValidationException extends GeneralAPIException {

    private static final String DEFAULT_MESSAGE = "Input validation error occurred";

    private BindingResult result;


    public InputValidationException(BindingResult result) {
        this.result = result;
    }


    //email NotBlank
    //email Length
    //age: NotNull
    //firstName: NotBlank
    //firstName: Length
    //firstName: NotNull
    //

    //email: Length, NotBlank, Email
    //age: NotNull
    //firstName: NotBlank, Length
    private Map<String, List<String>> getErrors() {
        return this.result
                .getFieldErrors() //List<FieldError>
                .stream()
                .collect(
                        Collectors.groupingBy(
                                x -> x.getField(),
                                Collectors.mapping(x -> x.getDefaultMessage(), Collectors.toList())
                        )
                );
    }

    @Override
    public String getDefaultMessage() {
        return DEFAULT_MESSAGE;
    }

    @Override
    public ErrorResponse getErrorResponse() {
        return ErrorResponse.builder()
                .message(getDefaultMessage())
                .data(getErrors())
                .build();
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
