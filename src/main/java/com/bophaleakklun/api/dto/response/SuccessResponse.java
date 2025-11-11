package com.bophaleakklun.api.dto.response;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

public class SuccessResponse<T> {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message = null;
    
    private HttpStatus status;
    private int statusCode;
}
