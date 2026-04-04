package com.example.employeeDeptApi.repositories;

import org.springframework.data.jpa.repository.*;
import com.example.employeeDeptApi.entities.*;
import com.example.employeeDeptApi.dto.*;

import java.util.*;


public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    Optional<Department> findByName(String name);

    @Query("SELECT new com.example.employeeDeptApi.dto.DepartmentCountDTO(d.name, COUNT(e)) " +
           "FROM Department d LEFT JOIN d.employees e GROUP BY d.name")
    List<DepartmentCountDTO> countEmployees();
}