package com.example.demo.entity;

import java.util.Set;

import org.springframework.data.annotation.Id;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "Name cannot be empty")

	private String name;
	@Positive(message = "Salary must be greater than 0")
	private int salary;
	
	@ElementCollection
	private Set<String>mobileNumbers;
	@ManyToOne
	private Department department;
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Set<String> getMobileNumbers() {
		return mobileNumbers;
	}
	public void setMobileNumbers(Set<String> mobileNumbers) {
		this.mobileNumbers = mobileNumbers;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
	
	

}
