package com.example.demo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.PlanningProjet;
import com.example.demo.entity.PlanningProjetPk;

public interface PlanningProjetRepository extends JpaRepository<PlanningProjet, Long>{

	@Query("SELECT p FROM PlanningProjet p WHERE p.etat = 'FALSE'")
	List<PlanningProjet> findAllPlanifie();
	
	@Query("SELECT p FROM PlanningProjet p WHERE p.etat = 'TRUE'")
	List<PlanningProjet> findAllRealise();
	

	PlanningProjet findByNumPlanning(Long numPlanning);
	
	
}
