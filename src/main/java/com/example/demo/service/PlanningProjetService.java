package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PlanningProjet;
import com.example.demo.respository.PlanningProjetRepository;
import com.example.demo.service.interfaces.IPlanningProjet;

@Service
@Primary
public class PlanningProjetService implements ICrudService<PlanningProjet, Long>,IPlanningProjet{

	@Autowired
	PlanningProjetRepository planningProjetRepository;
	@Override
	public List<PlanningProjet> getAll() {
		return planningProjetRepository.findAll();
	}

	@Override
	public void add(PlanningProjet entity) {
		planningProjetRepository.save(entity)	;	
	}

	@Override
	public void update(PlanningProjet entity) {
		planningProjetRepository.save(entity)	;	
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PlanningProjet> getAllPlanifie() {
		return planningProjetRepository.findAllPlanifie();
	}

	@Override
	public List<PlanningProjet> getAllRealise() {
		return planningProjetRepository.findAllRealise();
	}

}
