package com.example.employeeDeptApi.controllers;

import org.springframework.web.bind.annotation.*;
import com.example.employeeDeptApi.services.*;
import com.example.employeeDeptApi.entities.*;
import com.example.employeeDeptApi.dto.*;

import jakarta.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService service;

    // Constructor Injection
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping("/employee/{deptName}")
    public Employee addEmployee(@Valid @RequestBody Employee emp,
                                @PathVariable String deptName) {
        return service.addEmployee(emp, deptName);
    }

    @GetMapping("/employees")
    public List<EmployeeDepartmentDTO> getAll() {
        return service.getAllEmployees();
    }

    @GetMapping("/departments/count")
    public List<DepartmentCountDTO> count() {
        return service.countEmployees();
    }

    @GetMapping("/employees/department/{name}")
    public List<Employee> getByDept(@PathVariable String name) {
        return service.getByDept(name);
    }

    @GetMapping("/employee/mobile/{mobile}")
    public EmployeeMobileDTO getByMobile(@PathVariable String mobile) {
        return service.getByMobile(mobile);
    }
}