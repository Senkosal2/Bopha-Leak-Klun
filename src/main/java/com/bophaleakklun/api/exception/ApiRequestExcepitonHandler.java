package com.bophaleakklun.api.exception;

import java.time.ZonedDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bophaleakklun.api.dto.response.ErrorResponse;
import com.bophaleakklun.api.dto.response.InvalidResponse;

@ControllerAdvice
public class ApiRequestExcepitonHandler {

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<ErrorResponse> handleNotFound(NotFoundException notFound) {
        ErrorResponse response = new ErrorResponse(
            HttpStatus.NOT_FOUND,
            404,
            notFound.getMessage(),
            ZonedDateTime.now());
        return new ResponseEntity<>(response, response.getStatus());
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<InvalidResponse<Map<String, String>>> handleBadRequest(
        BadRequestException badRequest) {

        // Map<String, String> invalid = badRequest.getInvalidField();

        InvalidResponse<Map<String, String>> response = new InvalidResponse<>();
        // response.setStatus(HttpStatus.BAD_REQUEST);
        // response.setStatusCode(400);
        // response.setFields(invalid);

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler({ForbiddenException.class}) 
    public ResponseEntity<ErrorResponse> handleForbidden(ForbiddenException e) {
        ErrorResponse response = new ErrorResponse(
            HttpStatus.FORBIDDEN, 
            403, 
            e.getMessage(), 
            ZonedDateTime.now());

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }

    // @ExceptionHandler(NoHandlerFoundException.class)
    // public ResponseEntity<InvalidResponse<List<String>>> routeNotFound(NoHandlerFoundException e) {
    //     InvalidResponse<List<String>> invalidResponse = new InvalidResponse<>();
    //     invalidResponse.setStatus(HttpStatus.NOT_FOUND);
    //     invalidResponse.setStatusCode(404);
    //     invalidResponse.setMessage("Route not exists: " + e.getRequestURL());
    //     invalidResponse.setUri(List.of(
    //         "/api/users"
    //     ));

    //     return new ResponseEntity<>(invalidResponse, HttpStatus.NOT_FOUND);
    // }
}
