package com.example.employeeDeptApi.exceptions;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DepartmentNameNotFoundException.class)
    public ResponseEntity<String> handleDept(DepartmentNameNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MobileNumberDoesNotExistsForEmployeeException.class)
    public ResponseEntity<String> handleMobile(MobileNumberDoesNotExistsForEmployeeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}