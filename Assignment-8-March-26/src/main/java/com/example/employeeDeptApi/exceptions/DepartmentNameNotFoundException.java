package com.example.employeeDeptApi.exceptions;

public class DepartmentNameNotFoundException extends RuntimeException {
    public DepartmentNameNotFoundException(String msg) {
        super(msg);
    }
}