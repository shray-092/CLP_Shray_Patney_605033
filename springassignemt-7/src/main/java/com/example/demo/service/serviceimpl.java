package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DepartmentEmployeeCountDTO;
import com.example.demo.dto.EmployeeDepartmentByMobileDTO;
import com.example.demo.dto.EmployeeDepartmentDTO;
import com.example.demo.entity.Employee;
import com.example.demo.repository.Employeerepo;
import com.example.demo.exception.MobileNumberDoesNotExistsForEmployeeException;

@Service
public class serviceimpl implements serviceinter {

	@Autowired
	Employeerepo employeerepo;

	@Override
	public Employee insertEmployee(Employee employee) {
		return employeerepo.save(employee);
	}

	@Override
	public List<EmployeeDepartmentDTO> getAllEmployeesWithDept() {
		List<Employee> e = employeerepo.findAllEmployeesWithDepartment();
		List<EmployeeDepartmentDTO> empDeptDTOList = new ArrayList<>();
		for (Employee emp : e) {
			EmployeeDepartmentDTO empDeptDTO = new EmployeeDepartmentDTO();
			empDeptDTO.setEmpId(emp.getId());
			empDeptDTO.setEmpName(emp.getName());
			empDeptDTO.setDeptName(emp.getDepartment().getName());
			empDeptDTOList.add(empDeptDTO);
		}
		return empDeptDTOList;
	}

	@Override
	public List<Employee> getEmployeesByDeptName(String name) {
		List<Employee> list = employeerepo.findByDepartment_Name(name);
		if (list.isEmpty()) {
			throw new RuntimeException("Department not found");
		}
		return list;
	}

	@Override
	public List<DepartmentEmployeeCountDTO> getEmployeeCountByDept() {
		List<Object[]> list = employeerepo.countEmployeesByDept();
		List<DepartmentEmployeeCountDTO> result = new ArrayList<>();
		for (Object[] obj : list) {
			DepartmentEmployeeCountDTO dto = new DepartmentEmployeeCountDTO();
			dto.setDeptName((String) obj[0]);
			dto.setCount((Long) obj[1]);
			result.add(dto);
		}
		return result;
	}

	@Override
	public EmployeeDepartmentByMobileDTO getEmployeeByMobile(String mobile) {
		Employee e = employeerepo.findByMobile(mobile);
		if (e == null) {
			throw new MobileNumberDoesNotExistsForEmployeeException(
					"Mobile number not found: " + mobile);
		}
		EmployeeDepartmentByMobileDTO dto = new EmployeeDepartmentByMobileDTO();
		dto.setEmpId(e.getId());
		dto.setEmpName(e.getName());
		dto.setDeptName(e.getDepartment().getName());
		dto.setManagerName(e.getDepartment().getManagerName());
		return dto;
	}
}
