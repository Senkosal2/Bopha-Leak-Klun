package com.bophaleakklun.api.exception;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// import lombok.Getter;

@ResponseStatus(HttpStatus.BAD_REQUEST)
// @Getter
public class BadRequestException extends RuntimeException{

    private Map<String, String> invalidField;

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(Map<String, String> invalidField) {
        super();
        this.invalidField = invalidField;
    }
}
