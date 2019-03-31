package com.example.demo.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.PlanningProjet;
import com.example.demo.entity.RapportProjet;
import com.example.demo.respository.PlanningProjetRepository;
import com.example.demo.service.PlanningProjetService;
import com.example.demo.service.RapportProjetService;

@RestController
@RequestMapping("/crud_rapport")
@CrossOrigin
public class RapportProjetController extends CrudController<RapportProjet, Long> {

	@Autowired
	RapportProjetService rapportProjetService;
	@Autowired
	PlanningProjetRepository planningProjetRepository;
	
	@RequestMapping(value="/Add/{numPlanning}", method = RequestMethod.POST)
	public ResponseEntity addPlanningProjet(@RequestBody RapportProjet rapport,@PathVariable Long numPlanning) {
		//String contexte = (String) mapper.get("contexte");
		//Integer numPlanning = (Integer) mapper.get("numPlanning");
        // Long num = numPlanning.longValue();

		
		PlanningProjet planning = planningProjetRepository.findByNumPlanning(numPlanning);
		//RapportProjet rapport = new RapportProjet();
		//rapport.setContexte(contexte);
		rapport.setPlanningProjet(planning);
		rapportProjetService.add(rapport);
		
		return new ResponseEntity<>(HttpStatus.OK);

	}
}
