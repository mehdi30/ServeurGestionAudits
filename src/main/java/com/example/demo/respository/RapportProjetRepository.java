package com.example.demo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.RapportProjet;


public interface RapportProjetRepository  extends JpaRepository<RapportProjet, Long>{

	List<RapportProjet> findByPlanningProjetNumPlanning(Long num);
	

}
