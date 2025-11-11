package com.bophaleakklun.api.dto.response;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
    private final HttpStatus status;
    private final int statusCode;
    private final String message;
    private final ZonedDateTime timeStamp;

    public ErrorResponse(
                            HttpStatus httpStatus,
                            Integer httpStatusCode,
                            String message,
                            ZonedDateTime timestamp) {
        this.message = message;
        this.status = httpStatus;
        this.statusCode = httpStatusCode;
        this.timeStamp = timestamp;
    }

    public HttpStatus getStatus() { return status; }
    public int getStatusCode() { return statusCode; }
    public String getMessage() { return message; }
    public ZonedDateTime getTimeStamp() { return timeStamp; }
}
