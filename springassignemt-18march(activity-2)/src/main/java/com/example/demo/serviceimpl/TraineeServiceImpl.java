package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Trainee;
import com.example.demo.repository.TraineeRepository;
import com.example.demo.service.TraineeService;

@Service
public class TraineeServiceImpl implements TraineeService {
	@Autowired
	TraineeRepository train;

	@Override
	public Trainee serviceinsert(Trainee t) {
		Trainee e=train.save(t);
		
		
		return e;
	}

	@Override
	public Trainee serviceupdate(int id, Trainee t) {
		Trainee e= train.findById(id).orElse(null);
		if(e!=null) {
			e.setTraineeId(t.getTraineeId());
			e.setTraineeDomain(t.getTraineeDomain());
			e.setTraineeName(t.getTraineeName());
			e.setTraineelocation(t.getTraineelocation());
			train.save(e);
			return e;
		}
		return null;
		
	
	}

	@Override
	public Trainee servicedelete(int id) {
		Trainee t=train.findById(id).orElse(null);
		if(t!=null) {
			train.deleteById(id);
		}
		
		return t;
	}

	@Override
	public List<Trainee> servicedisplay() {
		
		
		return train.findAll();
	}

}
