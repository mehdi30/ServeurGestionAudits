package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Projet;
import com.example.demo.respository.ProjetRepository;

@Service
@Primary
public class ProjetService implements ICrudService<Projet, Long>{

	@Autowired
	private ProjetRepository projetRepository;
	@Override
	public List<Projet> getAll() {
		return projetRepository.findAll();
	}

	@Override
	public void add(Projet entity) {

		projetRepository.save(entity);
	}

	@Override
	public void update(Projet entity) {
		projetRepository.save(entity);
		
	}

	@Override
	public void delete(Long id) {

		Projet projet = new Projet();
		projet.setId(id);
		projetRepository.delete(projet);
		
	}

}
