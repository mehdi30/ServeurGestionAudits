package com.example.demo.service.interfaces;

import java.util.List;

import com.example.demo.entity.PlanningProjet;


public interface IPlanningProjet {

	List<PlanningProjet> getAllPlanifie();
	List<PlanningProjet> getAllRealise();
	PlanningProjet getPlanningByNumPlanning(Long num);
}
