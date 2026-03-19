package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.*;

public interface TraineeService {
	public Trainee serviceinsert(Trainee t);
	public Trainee serviceupdate(int id,Trainee t);
	public Trainee servicedelete(int id);
	public List<Trainee>servicedisplay();
	
	

}
