package com.bophaleakklun.api.exception;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bophaleakklun.api.dto.response.InvalidResponse;

@RestControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<InvalidResponse<Map<String, String>>> handleValidation(
        MethodArgumentNotValidException e) {
        Map<String, String> errorMessage = new LinkedHashMap<>();
        e.getBindingResult().getFieldErrors().forEach(errorField -> {
            errorMessage.put(errorField.getField(), errorField.getDefaultMessage());
        });
        InvalidResponse<Map<String, String>> invalidResponse = new InvalidResponse<>();
        // invalidResponse.setMessage("Invalid fields");
        // invalidResponse.setStatus(HttpStatus.BAD_REQUEST);
        // invalidResponse.setStatusCode(405);
        // invalidResponse.setFields(errorMessage);
        return new ResponseEntity<>(invalidResponse, HttpStatus.BAD_REQUEST);
    }
}
