
package com.example.employeeDeptApi.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.*;

import com.example.employeeDeptApi.dto.EmployeeDepartmentDTO;
import com.example.employeeDeptApi.dto.EmployeeMobileDTO;
import com.example.employeeDeptApi.entities.Department;
import com.example.employeeDeptApi.entities.Employee;
import com.example.employeeDeptApi.exceptions.DepartmentNameNotFoundException;
import com.example.employeeDeptApi.exceptions.MobileNumberDoesNotExistsForEmployeeException;
import com.example.employeeDeptApi.repositories.DepartmentRepository;
import com.example.employeeDeptApi.repositories.EmployeeRepository;
import com.example.employeeDeptApi.services.EmployeeService;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository empRepo;

    @Mock
    private DepartmentRepository deptRepo;

    @InjectMocks
    private EmployeeService service;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    //Add Employee SUCCESS
    @Test
    void testAddEmployeeSuccess() {

        Department dept = new Department();
        dept.setName("IT");

        Employee emp = new Employee();
        emp.setName("Suyash");

        when(deptRepo.findByName("IT")).thenReturn(Optional.of(dept));
        when(empRepo.save(emp)).thenReturn(emp);

        Employee result = service.addEmployee(emp, "IT");

        assertNotNull(result);
        assertEquals("Suyash", result.getName());
    }

    //Department NOT FOUND
    @Test
    void testAddEmployeeFail() {

        Employee emp = new Employee();

        when(deptRepo.findByName("IT")).thenReturn(Optional.empty());

        assertThrows(DepartmentNameNotFoundException.class,
                () -> service.addEmployee(emp, "IT"));
    }

    //Fetch all employees
    @Test
    void testGetAllEmployees() {

        List<EmployeeDepartmentDTO> list = new ArrayList<>();
        list.add(new EmployeeDepartmentDTO(1, "Suyash", "IT", "Rahul"));

        when(empRepo.getEmployeeDeptDetails()).thenReturn(list);

        List<EmployeeDepartmentDTO> result = service.getAllEmployees();

        assertEquals(1, result.size());
    }

    //Department empty
    @Test
    void testGetByDeptFail() {

        when(empRepo.findByDepartmentName("IT"))
                .thenReturn(new ArrayList<>());

        assertThrows(DepartmentNameNotFoundException.class,
                () -> service.getByDept("IT"));
    }

    //Mobile found
    @Test
    void testGetByMobile() {

        EmployeeMobileDTO dto =
                new EmployeeMobileDTO(1, "Suyash", "IT", "Rahul");

        when(empRepo.findByMobile("9999"))
                .thenReturn(Optional.of(dto));

        EmployeeMobileDTO result = service.getByMobile("9999");

        assertEquals("Suyash", result.getEmpName());
    }

    // Mobile NOT found
    @Test
    void testGetByMobileFail() {

        when(empRepo.findByMobile("9999"))
                .thenReturn(Optional.empty());

        assertThrows(MobileNumberDoesNotExistsForEmployeeException.class,
                () -> service.getByMobile("9999"));
    }
}