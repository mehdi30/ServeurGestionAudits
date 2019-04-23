package com.example.demo.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import com.example.demo.entity.Departement;
import com.example.demo.entity.EnJeux;
import com.example.demo.entity.PlanningProjet;
import com.example.demo.entity.RapportProjet;
import com.example.demo.entity.Source;
import com.example.demo.entity.User;
import com.example.demo.respository.ActionProjetRepository;
import com.example.demo.respository.DepartementRepository;
import com.example.demo.respository.EnjeuxRepository;
import com.example.demo.respository.PlanningProjetRepository;
import com.example.demo.respository.RapportProjetRepository;
import com.example.demo.respository.SourceRepository;
import com.example.demo.respository.UserRepository;
import com.example.demo.service.ActionProjetService;
import com.example.demo.util.EfficaciteEnum;
import com.example.demo.util.RessourceEnum;
import com.example.demo.util.StatusEnum;
import com.example.demo.util.TypeActionEnum;

@RestController
@RequestMapping("/crud_action_projet")
@CrossOrigin
public class ActionProjetController extends CrudController<ActionProjet, Long> {

	@Autowired
	ActionProjetService actionProjetService;

	@Autowired
	PlanningProjetRepository planningProjetRepository;

	@Autowired
	RapportProjetRepository rapportProjetRepository;

	@Autowired
	EnjeuxRepository enJeuxRepository;

	@Autowired
	SourceRepository sourceRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	DepartementRepository departmentRepository;
	
	@Autowired
	ActionProjetRepository actionProjetRepository;

	@RequestMapping(value = "/AAS", method = RequestMethod.POST)
	public ResponseEntity addActionProjets(@RequestBody HashMap<String, Object> mapper) {

		Long ide = Long.parseLong((String) mapper.get("enJeux"));
		Long idd = Long.parseLong((String) mapper.get("departement"));

		String cause = ((String) mapper.get("cause"));
		Long ids = Long.parseLong((String) mapper.get("source"));
		LocalDateTime dlancement = LocalDateTime.now();

		EnJeux enjeux = enJeuxRepository.getOne(ide);
		Source source = sourceRepository.getOne(ids);
		Departement departement = departmentRepository.getOne(idd);
		ActionProjet action = new ActionProjet();
		action.setDepartement(departement);
		action.setDateLancement(dlancement);
		action.setSource(source);
		action.setEnJeux(enjeux);
		action.setCause(cause);

		actionProjetService.add(action);

		return new ResponseEntity<>(HttpStatus.OK);

	}

	@RequestMapping(value = "/AAP/{id}", method = RequestMethod.POST)
	public ResponseEntity addActionProjet(@RequestBody HashMap<String, Object> mapper, @PathVariable Long id) {

		Long ide = Long.parseLong((String) mapper.get("enJeux"));
		String cause = ((String) mapper.get("cause"));
		LocalDateTime dlancement = LocalDateTime.now();

		//Long idr = Long.parseLong((String) mapper.get("responsable"));
		//User responsable = userRepository.getOne(idr);

		RapportProjet rapport = rapportProjetRepository.getOne(id);
		EnJeux enjeux = enJeuxRepository.getOne(ide);
		ActionProjet action = new ActionProjet();
		action.setCause(cause);
		action.setDateLancement(dlancement);
		action.setEnJeux(enjeux);
		action.setRapportProjet(rapport);
		
		actionProjetService.add(action);

		return new ResponseEntity<>(HttpStatus.OK);

	}

	/*
	 * @RequestMapping(value = "/UAP/{id}", method = RequestMethod.PUT) public void
	 * validerActionProjet(@RequestBody HashMap<String, Object>
	 * mapper, @PathVariable Long id) { String methode = ((String)
	 * mapper.get("methode")); String efficacite = ((String)
	 * mapper.get("efficacite")); String commentaire = ((String)
	 * mapper.get("commentaire")); String status = ((String) mapper.get("status"));
	 * 
	 * ActionProjet action = actionProjetRepository.getOne(id); EfficaciteEnum h = ;
	 * h.setName(efficacite); action.setEfficacite(h); StatusEnum sta =
	 * action.getStatus(); sta.setName(status); action.setStatus(sta);
	 * 
	 * 
	 * action.setMethode(methode); action.setCommentaire(commentaire);
	 * 
	 * actionProjetService.update(action);
	 * 
	 * }
	 */
	@RequestMapping(value = "/UAP/{id}", method = RequestMethod.PUT)
	public void validerActionProjet(@RequestBody ActionProjet action, @PathVariable Long id) {

		actionProjetService.updateActionProjet(id, action);

	}

	/*
	 * @RequestMapping(value = "/planifiee/{status}", method = RequestMethod.GET)
	 * public List<ActionProjet> getByStatus(@PathVariable StatusEnum status) {
	 * 
	 * return actionProjetService.getByStatus(status);
	 * 
	 * }
	 */
}
