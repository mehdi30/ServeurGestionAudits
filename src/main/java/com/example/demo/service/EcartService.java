package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Ecart;
import com.example.demo.respository.EcartRepository;

@Service
@Primary
public class EcartService implements ICrudService<Ecart, Long>{

	@Autowired
	private EcartRepository ecartRepository;
	
	
	@Override
	public List<Ecart> getAll() {
		return ecartRepository.findAll();
	}

	@Override
	public void add(Ecart entity) {
		ecartRepository.save(entity)	;	
	}

	@Override
	public void update(Ecart entity) {
		ecartRepository.save(entity);		
	}

	@Override
	public void delete(Long id) {

		Ecart e = new Ecart();
		e.setId(id);
		ecartRepository.delete(e);
	}

}
