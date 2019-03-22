package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Audit;
import com.example.demo.respository.AuditRepository;
import com.example.demo.respository.ProjetRepository;

@Service
@Primary
public class AuditService implements ICrudService<Audit, Long>{

	@Autowired
	private AuditRepository auditRepository;
	@Override
	public List<Audit> getAll() {
		return auditRepository.findAll();
	}

	@Override
	public void add(Audit entity) {
		auditRepository.save(entity);		
	}

	@Override
	public void update(Audit entity) {
		auditRepository.save(entity);		
		
	}

	@Override
	public void delete(Long id) {
 
		Audit audit = new Audit();
		audit.setId(id);
		auditRepository.delete(audit);
	}

}
