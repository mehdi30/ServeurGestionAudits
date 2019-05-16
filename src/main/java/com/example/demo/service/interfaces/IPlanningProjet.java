package com.example.demo.service.interfaces;

import java.util.List;

import com.example.demo.entity.PlanningProjet;
import com.example.demo.util.EtatPlanningEnum;


public interface IPlanningProjet {

	List<PlanningProjet> countByMonths();
	//List<PlanningProjet> getAllRealise();
	PlanningProjet getPlanningByNumPlanning(Long num);
	public long countByEtatPlanning(EtatPlanningEnum e) ;
}
