package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.DepartmentEmployeeCountDTO;
import com.example.demo.dto.EmployeeDepartmentByMobileDTO;
import com.example.demo.dto.EmployeeDepartmentDTO;
import com.example.demo.entity.Employee;

public interface serviceinter {
	public Employee insertEmployee(Employee employee);
	List<EmployeeDepartmentDTO> getAllEmployeesWithDept();
	List<Employee>getEmployeesByDeptName(String name);
	
	public EmployeeDepartmentByMobileDTO getEmployeeByMobile(String mobile);
	List<DepartmentEmployeeCountDTO> getEmployeeCountByDept();
	

	

}
