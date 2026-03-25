package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Employee;

public interface Employeerepo extends JpaRepository<Employee, Long> {
	@Query("select e from Employee e join fetch e.department")
	public List<Employee> findAllEmployeesWithDepartment();
	
	
	List<Employee> findByDepartment_Name(String name);
	@Query("SELECT e FROM Employee e JOIN e.mobileNumbers m WHERE m = :mobile")
	Employee findByMobile(String mobile);


	public List<Object[]> countEmployeesByDept();

}
