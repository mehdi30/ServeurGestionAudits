package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Departement;
import com.example.demo.respository.DepartementRepository;

@Service
@Primary
public class DepartementService implements ICrudService<Departement, Long> {

	@Autowired
	private DepartementRepository departementRepository;
	
	@Override
	public List<Departement> getAll() {
		return departementRepository.findAll();
	}

	@Override
	public void add(Departement depart) {
		departementRepository.save(depart);		
	}

	@Override
	public void update(Departement depart) {
		departementRepository.save(depart);		
		
	}

	@Override
	public void delete(Long id) {
     Departement depart = new Departement();
     depart.setIdDep(id);
     departementRepository.delete(depart);
	}

}
