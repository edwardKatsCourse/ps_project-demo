package com.example.forumdemo.model.web;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL) //не печатай поле, если оно null
public class ErrorResponse {

    private String message; //Input validation error occurred
    private Object data; //Map of actual errors
}
