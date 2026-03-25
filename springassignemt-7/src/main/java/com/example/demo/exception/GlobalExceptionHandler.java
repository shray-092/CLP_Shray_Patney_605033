
package com.example.demo.exception;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exception.MobileNumberDoesNotExistsForEmployeeException;

import org.springframework.http.*;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MobileNumberDoesNotExistsForEmployeeException.class)
    public ResponseEntity<String> handleMobile(MobileNumberDoesNotExistsForEmployeeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}