package com.example.demo.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "trainee")
public class Trainee {
	@Id
	@GeneratedValue
	private int traineeId;
	private String traineeName;
	private String traineeDomain;
	private String traineelocation;
	public int getTraineeId() {
		return traineeId;
	}
	public Trainee(int traineeId, String traineeName, String traineeDomain, String traineelocation) {
		super();
		this.traineeId = traineeId;
		this.traineeName = traineeName;
		this.traineeDomain = traineeDomain;
		this.traineelocation = traineelocation;
	}
	public Trainee() {
		// TODO Auto-generated constructor stub
	}
	public void setTraineeId(int traineeId) {
		this.traineeId = traineeId;
	}
	public String getTraineeName() {
		return traineeName;
	}
	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}
	public String getTraineeDomain() {
		return traineeDomain;
	}
	public void setTraineeDomain(String traineeDomain) {
		this.traineeDomain = traineeDomain;
	}
	public String getTraineelocation() {
		return traineelocation;
	}
	public void setTraineelocation(String traineelocation) {
		this.traineelocation = traineelocation;
	}
	

}
