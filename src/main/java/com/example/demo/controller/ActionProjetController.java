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

import com.example.demo.entity.ActionProjet;
import com.example.demo.entity.PlanningProjet;
import com.example.demo.entity.RapportProjet;
import com.example.demo.respository.ActionProjetRepository;
import com.example.demo.respository.PlanningProjetRepository;
import com.example.demo.service.ActionProjetService;
import com.example.demo.util.EfficaciteEnum;
import com.example.demo.util.StatusEnum;

@RestController
@RequestMapping("/crud_action_projet")
@CrossOrigin
public class ActionProjetController extends CrudController<ActionProjet, Long> {

	@Autowired
	ActionProjetService actionProjetService;

	@Autowired
	PlanningProjetRepository planningProjetRepository;

	@Autowired
	ActionProjetRepository actionProjetRepository;

	@RequestMapping(value = "/AAP/{numPlanning}", method = RequestMethod.POST)
	public ResponseEntity addActionProjet(@RequestBody ActionProjet action, @PathVariable Long numPlanning) {

		PlanningProjet planning = planningProjetRepository.findByNumPlanning(numPlanning);
		// RapportProjet rapport = new RapportProjet();
		// rapport.setContexte(contexte);
		// planning.setEtat(true);
		action.setPlanningProjet(planning);
		action.setStatus(StatusEnum.Planifiée);
		//action.setEfficacite(EfficaciteEnum.NonEfficace);
		actionProjetService.add(action);

		return new ResponseEntity<>(HttpStatus.OK);

	}

	/*@RequestMapping(value = "/UAP/{id}", method = RequestMethod.PUT)
	public void validerActionProjet(@RequestBody HashMap<String, Object> mapper, @PathVariable Long id) {
		String methode = ((String) mapper.get("methode"));
		String efficacite = ((String) mapper.get("efficacite"));
		String commentaire = ((String) mapper.get("commentaire"));
		String status = ((String) mapper.get("status"));

		ActionProjet action = actionProjetRepository.getOne(id);
		EfficaciteEnum  h = ;
	    h.setName(efficacite);
		action.setEfficacite(h);
		StatusEnum sta = action.getStatus();
		sta.setName(status);
		action.setStatus(sta);
		

		action.setMethode(methode);
		action.setCommentaire(commentaire);
		
		actionProjetService.update(action);

	}*/
	@RequestMapping(value = "/UAP/{id}", method = RequestMethod.PUT)
	public void validerActionProjet(@RequestBody ActionProjet action, @PathVariable Long id) {
		


		
		actionProjetService.updateActionProjet(id, action);

	}

	@RequestMapping(value = "/planifiee/{status}", method = RequestMethod.GET)
	public List<ActionProjet> getByStatus(@PathVariable StatusEnum status) {

		return actionProjetService.getByStatus(status);

	}
}
