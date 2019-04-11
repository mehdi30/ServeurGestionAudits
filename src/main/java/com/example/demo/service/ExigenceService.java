package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Exigence;
import com.example.demo.respository.EnjeuxRepository;
import com.example.demo.respository.ExigenceRepository;

@Service
@Primary
public class ExigenceService implements ICrudService<Exigence, Long>{

	@Autowired
	private ExigenceRepository exigenceRepository;
	
	@Override
	public List<Exigence> getAll() {
		// TODO Auto-generated method stub
		return exigenceRepository.findAll();
	}

	@Override
	public void add(Exigence entity) {
		exigenceRepository.save(entity);
	}

	@Override
	public void update(Exigence entity) {
		exigenceRepository.save(entity);
		
	}

	@Override
	public void delete(Long id) {

		Exigence exigence = new Exigence();
		exigence.setId(id);
		exigenceRepository.delete(exigence);
		
	}

}
