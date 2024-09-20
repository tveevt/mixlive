package com.example.mixlive.config;

import cn.hutool.json.JSONUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.AccessDeniedException;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> illegalArgumentException(IllegalArgumentException e) {
        return handleException(HttpStatus.BAD_REQUEST, e);
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<String> illegalStateException(IllegalStateException e) {
        return handleException(HttpStatus.BAD_REQUEST, e);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<String> handleAccessDeniedException(AccessDeniedException e) {
        return handleException(HttpStatus.FORBIDDEN, e);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exception(Exception e) {
        return handleException(HttpStatus.INTERNAL_SERVER_ERROR, e);
    }

    private static ResponseEntity<String> handleException(HttpStatus httpStatus, Exception e) {
        log.error(e.getMessage(), e);
        ErrorResponse errorResponse = new ErrorResponse(httpStatus.value(), e.toString());
        String jsonResponse = JSONUtil.toJsonStr(errorResponse);
        return ResponseEntity.status(httpStatus).body(jsonResponse);
    }

    @Data
    public static class ErrorResponse {
        private int code;
        private String message;

        public ErrorResponse(int code, String message) {
            this.code = code;
            this.message = message;
        }
    }
}