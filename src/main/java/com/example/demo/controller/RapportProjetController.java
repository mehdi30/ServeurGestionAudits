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

import com.example.demo.entity.Exigence;
import com.example.demo.entity.PlanningProjet;
import com.example.demo.entity.RapportProjet;
import com.example.demo.respository.ExigenceRepository;
import com.example.demo.respository.PlanningProjetRepository;
import com.example.demo.respository.RapportProjetRepository;
import com.example.demo.service.PlanningProjetService;
import com.example.demo.service.RapportProjetService;
import com.example.demo.util.TypeConstatEnum;

@RestController
@RequestMapping("/crud_rapport")
@CrossOrigin
public class RapportProjetController extends CrudController<RapportProjet, Long> {

	@Autowired
	RapportProjetService rapportProjetService;
	
	@Autowired
	RapportProjetRepository rapportProjetReposistory;
	PlanningProjetRepository planningProjetRepository;
	@Autowired
	ExigenceRepository exigenceRepository;

	@RequestMapping(value = "/Add/{numPlanning}", method = RequestMethod.POST)
	public ResponseEntity addPlanningProjet(@RequestBody HashMap<String, Object> mapper,
			@PathVariable Long numPlanning) {
		Long id = Long.parseLong((String) mapper.get("exigence"));

		String commentaire = ((String) mapper.get("commentaire"));
		String libelle = ((String) mapper.get("libelle"));
		String typeConstat = ((String) mapper.get("typeConstat"));
		String activite = ((String) mapper.get("activite"));

		Exigence exigence = exigenceRepository.getOne(id);
		PlanningProjet planning = planningProjetRepository.findByNumPlanning(numPlanning);
		//planning.setEtat(true);
		RapportProjet rapport = new RapportProjet();
		rapport.setActivite(activite);
		rapport.setCommentaire(commentaire);
		rapport.setLibelle(libelle);
		rapport.setTypeConstat(TypeConstatEnum.valueOf(typeConstat));
		rapport.setPlanningProjet(planning);
		rapport.setExigence(exigence);
		rapportProjetService.add(rapport);

		return new ResponseEntity<>(HttpStatus.OK);

	}

	@RequestMapping(value = "/Update/{id}", method = RequestMethod.PUT)
	public ResponseEntity updatePlanningProjet(@RequestBody HashMap<String, Object> mapper,

			@PathVariable Long id) {
		
		
		Long ide = Long.parseLong((String) mapper.get("exigence"));

		String commentaire = ((String) mapper.get("commentaire"));
		String libelle = ((String) mapper.get("libelle"));
		String typeConstat = ((String) mapper.get("typeConstat"));
		String activite = ((String) mapper.get("activite"));

		Exigence exigence = exigenceRepository.getOne(ide);
		RapportProjet rapport = rapportProjetReposistory.getOne(id);
		rapport.setActivite(activite);
		rapport.setCommentaire(commentaire);
		rapport.setLibelle(libelle);
		rapport.setTypeConstat(TypeConstatEnum.valueOf(typeConstat));
		rapport.setExigence(exigence);
		rapportProjetService.update(rapport);

		return new ResponseEntity<>(HttpStatus.OK);

	}

	@RequestMapping(value = "/details/{numPlanning}", method = RequestMethod.GET)
	public List<RapportProjet> getByNumPlanning(@PathVariable Long numPlanning) {

		return rapportProjetService.getByNumPlanning(numPlanning);

	}
}
