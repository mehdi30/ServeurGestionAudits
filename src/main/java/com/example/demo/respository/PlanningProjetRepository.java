package com.example.demo.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.PlanningProjet;
import com.example.demo.entity.PlanningProjetPk;

public interface PlanningProjetRepository extends JpaRepository<PlanningProjet,PlanningProjetPk>{

}
