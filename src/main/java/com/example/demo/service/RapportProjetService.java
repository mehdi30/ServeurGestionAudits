package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.entity.RapportProjet;
import com.example.demo.respository.RapportProjetRepository;

@Service
@Primary
public class RapportProjetService implements ICrudService<RapportProjet, Long>{

	@Autowired
	RapportProjetRepository rapportProjetRepository;
	
	@Override
	public List<RapportProjet> getAll() {
		// TODO Auto-generated method stub
		return rapportProjetRepository.findAll();
	}

	@Override
	public void add(RapportProjet entity) {

		rapportProjetRepository.save(entity);
	}

	@Override
	public void update(RapportProjet entity) {
		rapportProjetRepository.save(entity);	
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
