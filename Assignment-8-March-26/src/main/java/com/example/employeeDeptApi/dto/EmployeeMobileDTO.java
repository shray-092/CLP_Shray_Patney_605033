package com.example.employeeDeptApi.dto;

public class EmployeeMobileDTO {

    private Integer empId;
    private String empName;
    private String deptName;
    private String managerName;

    public EmployeeMobileDTO(Integer empId, String empName,
                             String deptName, String managerName) {
        this.empId = empId;
        this.empName = empName;
        this.deptName = deptName;
        this.managerName = managerName;
    }

    public Integer getEmpId() { return empId; }
    public String getEmpName() { return empName; }
    public String getDeptName() { return deptName; }
    public String getManagerName() { return managerName; }
}