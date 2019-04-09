package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Source;
import com.example.demo.respository.SourceRepository;

@Service
@Primary
public class SourceService implements ICrudService<Source, Long>{

	@Autowired
	SourceRepository sourceRepository;
	
	@Override
	public List<Source> getAll() {
		return sourceRepository.findAll();
	}

	@Override
	public void add(Source source) {
		sourceRepository.save(source)	;	
	}

	@Override
	public void update(Source source) {
		sourceRepository.save(source)	;	
		
	}

	@Override
	public void delete(Long id) {
      Source source = new Source();
      source.setId(id);
      sourceRepository.delete(source);
	}

}
