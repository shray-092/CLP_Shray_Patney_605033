package com.example.demo.dto;

public class DepartmentEmployeeCountDTO {

    private String deptName;
    private Long count;

    // Default Constructor
    public DepartmentEmployeeCountDTO() {
    }

    // Parameterized Constructor
    public DepartmentEmployeeCountDTO(String deptName, Long count) {
        this.deptName = deptName;
        this.count = count;
    }

    // Getters
    public String getDeptName() {
        return deptName;
    }

    public Long getCount() {
        return count;
    }

    // Setters
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}