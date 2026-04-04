package com.example.employeeDeptApi.dto;

public class DepartmentCountDTO {

    private String deptName;
    private long count;

    public DepartmentCountDTO(String deptName, long count) {
        this.deptName = deptName;
        this.count = count;
    }

    public String getDeptName() { return deptName; }
    public long getCount() { return count; }
}