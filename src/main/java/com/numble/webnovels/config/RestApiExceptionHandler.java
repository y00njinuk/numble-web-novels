package com.numble.webnovels.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.UUID;

@RestControllerAdvice
@Slf4j
public class RestApiExceptionHandler {
    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity<ErrorResponse> handleInternalServerException(RuntimeException ex) {
        String requestId = UUID.randomUUID().toString();
        log.info("Internal Server Error, requestId={}, message={}", requestId, ex.getMessage(), ex);

        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), requestId);
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Getter
    @AllArgsConstructor
    private class ErrorResponse {
        private String message;
        private String requestId;
    }
}
