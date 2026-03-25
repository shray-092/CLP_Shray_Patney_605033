package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.DepartmentEmployeeCountDTO;
import com.example.demo.dto.EmployeeDepartmentByMobileDTO;
import com.example.demo.dto.EmployeeDepartmentDTO;
import com.example.demo.entity.Employee;
import com.example.demo.service.serviceinter;

import jakarta.validation.Valid;

@RestController
public class Controller {

	@Autowired
	serviceinter s;

	@PostMapping("/employee")
	public Employee insertEmployee(@RequestBody @Valid Employee employee) {
		return s.insertEmployee(employee);
	}

	@GetMapping("/employees")
	public List<EmployeeDepartmentDTO> getAllEmployees() {
		return s.getAllEmployeesWithDept();
	}

	@GetMapping("/employees/department/{name}")
	public List<Employee> getByDept(@PathVariable String name) {
		return s.getEmployeesByDeptName(name);
	}

	@GetMapping("/departments/count")
	public List<DepartmentEmployeeCountDTO> getCount() {
		return s.getEmployeeCountByDept();
	}

	@GetMapping("/employees/mobile/{mobile}")
	public EmployeeDepartmentByMobileDTO getByMobile(@PathVariable String mobile) {
		return s.getEmployeeByMobile(mobile);
	}
}
