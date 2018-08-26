package com.example.forumdemo.handlers;


import com.example.forumdemo.exceptions.AbstractAPIException;
import com.example.forumdemo.model.web.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(AbstractAPIException.class)
    public ResponseEntity<ErrorResponse> handleAPIException(AbstractAPIException e) {

//        ErrorResponse errorResponse = ErrorResponse
//                .builder()
//                .message(e.getDefaultMessage())
//                .build();
        return new ResponseEntity<>(e.getErrorResponse(), e.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleSystemException(Exception e) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(status.getReasonPhrase())
                .data(e.getMessage())
                .build();

        return new ResponseEntity<>(errorResponse, status);
    }


}
