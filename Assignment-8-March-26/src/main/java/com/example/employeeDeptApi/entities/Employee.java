package com.example.employeeDeptApi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.*;

@Entity
public class Employee {

    @Id
    @SequenceGenerator(name="emp_seq", sequenceName="emp_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="emp_seq")
    private Integer id;

    @NotBlank(message="Name required")
    private String name;

    @Min(value = 1000, message="Salary must be >=1000")
    private double salary;

    @ElementCollection
    @CollectionTable(name="employee_mobile_numbers",
            joinColumns=@JoinColumn(name="employee_id"))
    @Column(name="mobile_number")
    @Size(min=1, message="At least one mobile required")
    private Set<String> mobileNumbers = new HashSet<>();

    @ManyToOne
    @JoinColumn(name="dept_id")
    private Department department;

    // Constructors
    public Employee() {}

    public Employee(Integer id, String name, double salary,
                    Set<String> mobileNumbers, Department department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.mobileNumbers = mobileNumbers;
        this.department = department;
    }

    // Getters & Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public Set<String> getMobileNumbers() { return mobileNumbers; }
    public void setMobileNumbers(Set<String> mobileNumbers) { this.mobileNumbers = mobileNumbers; }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }
}