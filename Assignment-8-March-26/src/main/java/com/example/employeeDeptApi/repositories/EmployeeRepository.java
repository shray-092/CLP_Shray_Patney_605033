package com.example.employeeDeptApi.repositories;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import com.example.employeeDeptApi.entities.*;
import com.example.employeeDeptApi.dto.*;

import java.util.*;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // JOIN FETCH (performance)
    @Query("SELECT e FROM Employee e JOIN FETCH e.department")
    List<Employee> fetchAllWithDepartment();

    // DTO projection
    @Query("SELECT new com.example.employeeDeptApi.dto.EmployeeDepartmentDTO(e.id, e.name, d.name, d.managerName) " +
           "FROM Employee e JOIN e.department d")
    List<EmployeeDepartmentDTO> getEmployeeDeptDetails();

    // By department name
    @Query("SELECT e FROM Employee e JOIN FETCH e.department d WHERE d.name = :name")
    List<Employee> findByDepartmentName(@Param("name") String name);

    // By mobile
    @Query("SELECT new com.example.employeeDeptApi.dto.EmployeeMobileDTO(e.id, e.name, d.name, d.managerName) " +
           "FROM Employee e JOIN e.department d JOIN e.mobileNumbers m WHERE m = :mobile")
    Optional<EmployeeMobileDTO> findByMobile(@Param("mobile") String mobile);
}