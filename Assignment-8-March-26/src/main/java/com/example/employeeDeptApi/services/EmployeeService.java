package com.example.employeeDeptApi.services;

import org.springframework.stereotype.Service;
import com.example.employeeDeptApi.repositories.*;
import com.example.employeeDeptApi.entities.*;
import com.example.employeeDeptApi.dto.*;
import com.example.employeeDeptApi.exceptions.*;

import java.util.*;

@Service
public class EmployeeService {

    private EmployeeRepository empRepo;
    private DepartmentRepository deptRepo;

    public EmployeeService(EmployeeRepository empRepo, DepartmentRepository deptRepo) {
        this.empRepo = empRepo;
        this.deptRepo = deptRepo;
    }

    public Employee addEmployee(Employee emp, String deptName) {
        Department dept = deptRepo.findByName(deptName)
                .orElseThrow(() -> new DepartmentNameNotFoundException("Department not found"));

        emp.setDepartment(dept);
        return empRepo.save(emp);
    }

    public List<EmployeeDepartmentDTO> getAllEmployees() {
        return empRepo.getEmployeeDeptDetails();
    }

    public List<DepartmentCountDTO> countEmployees() {
        return deptRepo.countEmployees();
    }

    public List<Employee> getByDept(String name) {
        List<Employee> list = empRepo.findByDepartmentName(name);

        if (list.isEmpty())
            throw new DepartmentNameNotFoundException("Department not found");

        return list;
    }

    public EmployeeMobileDTO getByMobile(String mobile) {
        return empRepo.findByMobile(mobile)
                .orElseThrow(() ->
                        new MobileNumberDoesNotExistsForEmployeeException("Mobile not found"));
    }
}