package com.example.employeeDeptApi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.*;

@Entity
public class Department {

    @Id
    @SequenceGenerator(name="dept_seq", sequenceName="dept_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="dept_seq")
    private Integer id;

    @NotBlank(message="Department name required")
    private String name;

    @NotBlank(message="Manager name required")
    private String managerName;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Employee> employees = new ArrayList<>();

    // Constructors
    public Department() {}

    public Department(Integer id, String name, String managerName) {
        this.id = id;
        this.name = name;
        this.managerName = managerName;
    }

    // Getters & Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getManagerName() { return managerName; }
    public void setManagerName(String managerName) { this.managerName = managerName; }

    public List<Employee> getEmployees() { return employees; }
    public void setEmployees(List<Employee> employees) { this.employees = employees; }
}