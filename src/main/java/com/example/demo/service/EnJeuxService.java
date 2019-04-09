package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.entity.EnJeux;
import com.example.demo.respository.EnjeuxRepository;


@Service
@Primary
public class EnJeuxService implements ICrudService<EnJeux,Long>{

	@Autowired
	private EnjeuxRepository enJeuxRepository;
	
	@Override
	public List<EnJeux> getAll() {
		return enJeuxRepository.findAll();
	}

	@Override
	public void add(EnJeux enJeux) {
		enJeuxRepository.save(enJeux);	
	}

	@Override
	public void update(EnJeux enJeux) {
		enJeuxRepository.save(enJeux);	
		
	}

	@Override
	public void delete(Long id) {
       EnJeux enJeux = new EnJeux();
       enJeux.setId(id);
       enJeuxRepository.delete(enJeux);
       
	}

}
