package com.example.demo.entity;

import java.util.List;




import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity

public class Department {
	 @Id
	    @GeneratedValue
	    private Long id;

	    public Long getId() {
		return id;
	}

	 public void setId(Long id) {
		 this.id = id;
	 }

	 public String getName() {
		 return name;
	 }

	 public void setName(String name) {
		 this.name = name;
	 }

	 public String getManagerName() {
		 return managerName;
	 }

	 public void setManagerName(String managerName) {
		 this.managerName = managerName;
	 }

	 public List<Employee> getEmployees() {
		 return employees;
	 }

	 public void setEmployees(List<Employee> employees) {
		 this.employees = employees;
	 }
	 
	 @NotBlank(message = "Department name required")

		private String name;

	 @NotBlank(message = "Manager name required")


	    private String managerName;

	    @OneToMany(mappedBy="department")
	    private List<Employee> employees;

}
