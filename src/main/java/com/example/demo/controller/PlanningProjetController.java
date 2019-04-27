package com.example.demo.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
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
import com.example.demo.entity.PlanningProjetPk;
import com.example.demo.entity.Projet;
import com.example.demo.entity.RapportProjet;
import com.example.demo.entity.User;
import com.example.demo.respository.ProjetRepository;
import com.example.demo.respository.UserRepository;
import com.example.demo.service.PlanningProjetService;
import com.example.demo.service.ProjetService;
import com.example.demo.util.TypePlanningEnum;

@RestController
@RequestMapping("/Planning_Projet")
@CrossOrigin
public class PlanningProjetController extends CrudController<PlanningProjet, Long> {

	@Autowired
	private PlanningProjetService planningProjetService;
	@Autowired
	private ProjetRepository projetRepository;
	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/s/{numPlanning}", method = RequestMethod.DELETE)
	public void deletebynum(@PathVariable Long numPlanning) {

		 planningProjetService.delete(numPlanning);


	}
	@RequestMapping("/List/Planifie")
	public List<PlanningProjet> AllPlanifie() {
		return planningProjetService.getAllPlanifie();

	}

	@RequestMapping("/List/Realise")
	public List<PlanningProjet> AllRealise() {
		return planningProjetService.getAllRealise();

	}

	@RequestMapping(value = "/Add", method = RequestMethod.POST)
	public ResponseEntity addPlanningProjet(@RequestBody HashMap<String, Object> mapper) {

		ArrayList<Integer> l = (ArrayList<Integer>) (mapper.get("user"));
		LocalDateTime datePlan = LocalDateTime.parse((String) mapper.get("datePlan"));
		Long idProjet = Long.parseLong((String) mapper.get("projet"));
		String description = ((String) mapper.get("description"));
		String typePlanning = ((String) mapper.get("typePlanning"));

		Projet projet = projetRepository.getOne(idProjet);

		PlanningProjet planningProjet = new PlanningProjet();
		List<User> list = new ArrayList<User>();

		for (Integer i = 1; i < l.size(); i++) {
			System.out.println(l.get(i));
			User auditeur = userRepository.getOne(l.get(i).longValue());
			list.add(auditeur);

		}
		planningProjet.setAuditeurs(list);

		planningProjet.setAudites(Arrays.asList(projet.getManager()));
		planningProjet.setIdProjet(idProjet);

		planningProjet.setDescription(description);

		planningProjet.setTypePlanning(TypePlanningEnum.valueOf(typePlanning));

		planningProjet.setDatePlan(datePlan);

		planningProjetService.add(planningProjet);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/AddD", method = RequestMethod.POST)
	public ResponseEntity addPlanningDepartement(@RequestBody HashMap<String, Object> mapper) {

		Long idDep = Long.parseLong((String) mapper.get("departement"));
		ArrayList<Integer> la = (ArrayList<Integer>) (mapper.get("audite"));
		String description = ((String) mapper.get("description"));

		ArrayList<Integer> l = (ArrayList<Integer>) (mapper.get("user"));

		LocalDateTime datePlan = LocalDateTime.parse((String) mapper.get("datePlan"));
		String typePlanning = ((String) mapper.get("typePlanning"));

		PlanningProjet planningProjet = new PlanningProjet();
		List<User> list = new ArrayList<User>();

		for (Integer i = 1; i < l.size(); i++) {

			User auditeur = userRepository.getOne(l.get(i).longValue());
			list.add(auditeur);
			
		}
		planningProjet.setAuditeurs(list);

		planningProjet.setIdDepartement(idDep);

		planningProjet.setTypePlanning(TypePlanningEnum.valueOf(typePlanning));

		planningProjet.setDescription(description);
		
		List<User> lista = new ArrayList<User>();
		System.out.println(l.get(0)+ "hedhiii sfer auditeur");
		System.out.println(la.get(0)+ "hedhiii sfer audite");

		for (Integer i = 1; i < la.size(); i++) {
				User auditeur = userRepository.getOne(la.get(i).longValue());
				lista.add(auditeur);
			
		

		}
		planningProjet.setAudites(lista);

		planningProjet.setDatePlan(datePlan);

		planningProjetService.add(planningProjet);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/details/{numPlanning}", method = RequestMethod.GET)
	public PlanningProjet getPlanningByNumPlanning(@PathVariable Long numPlanning) {

		return planningProjetService.getPlanningByNumPlanning(numPlanning);

	}

}
