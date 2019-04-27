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
	public PlanningProjet getPlanningByNumPlanning(Long num) {
		return planningProjetRepository.findByNumPlanning(num);
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
	public void delete(Long numPlanning) {

		PlanningProjet plan = new PlanningProjet();
		plan.setNumPlanning(numPlanning);
		planningProjetRepository.delete(plan);
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
