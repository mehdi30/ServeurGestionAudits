package com.example.demo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ActionProjet;
import com.example.demo.util.StatusEnum;


public interface ActionProjetRepository extends JpaRepository<ActionProjet, Long>{
	
	//List<ActionProjet> findByStatus(StatusEnum status);
    ActionProjet findByRapportProjetId(Long id);
}
