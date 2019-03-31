package com.example.demo.controller;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.PlanningProjet;
import com.example.demo.entity.PlanningProjetPk;
import com.example.demo.service.PlanningProjetService;

@RestController
@RequestMapping("/Planning_Projet")
@CrossOrigin
public class PlanningProjetController extends CrudController<PlanningProjet, Long>{

	@Autowired
	private PlanningProjetService planningProjetService;
	
	@RequestMapping("/List/Planifie")
	public List<PlanningProjet> AllPlanifie(){
		return planningProjetService.getAllPlanifie();
		
	}
	
	@RequestMapping("/List/Realise")
	public List<PlanningProjet> AllRealise(){
		return planningProjetService.getAllRealise();
		
	}
	
	@RequestMapping("/Add")
	public ResponseEntity addPlanningProjet(@RequestBody HashMap<String, Object>mapper) {
		
		//List<String> certifsList = (List<String>)mapper.get("certif");
		
		Long idAudit = Long.parseLong((String)mapper.get("audit"));
		Long idProjet =  Long.parseLong((String)mapper.get("projet"));
		Long idAuditeur =  Long.parseLong((String)mapper.get("user"));
		LocalDate datePlan = LocalDate.parse((String)mapper.get("datePlan"));

		//Long numPlanning = ((String)mapper.get("numplanning"));
		//Integer numPlanning = (Integer) mapper.get("numPlanning");
		/*Integer numPlanning = (Integer) mapper.get("numPlanning");
        Long num = numPlanning.longValue();*/

		/*PlanningProjetPk planningPk = new PlanningProjetPk();
		planningPk.setIdAudit(idAudit);
		planningPk.setIdAuditeur(idUser);
		planningPk.setIdProjet(idProjet);
		planningPk.setNumPlanning(num);*/
		PlanningProjet planningProjet = new PlanningProjet();
		planningProjet.setIdAudit(idAudit);
		planningProjet.setIdProjet(idProjet);
		planningProjet.setIdAuditeur(idAuditeur);
		planningProjet.setDatePlan(datePlan);
		
		//planningProjet.setPlanningProjetPk(planningPk);
		
		planningProjetService.add(planningProjet);
	
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
