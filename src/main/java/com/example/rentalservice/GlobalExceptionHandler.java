package com.example.rentalservice;

import java.net.ConnectException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
class GlobalExceptionHandler {

    // 404
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Object> handle404() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // 400
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handle400Readable() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handle400Mismatch() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    // 500 - 502
    @ExceptionHandler(HttpServerErrorException.class)
    public ResponseEntity<Object> handle500() {
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
    }

    // ConnectException
    @ExceptionHandler(ConnectException.class)
    public ResponseEntity<Object> handleConnectException() {
        return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).build();
    }

}