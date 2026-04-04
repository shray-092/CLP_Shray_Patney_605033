package com.example.employeeDeptApi.exceptions;


public class MobileNumberDoesNotExistsForEmployeeException extends RuntimeException {
    public MobileNumberDoesNotExistsForEmployeeException(String msg) {
        super(msg);
    }
}
