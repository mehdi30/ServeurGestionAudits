package com.example.demo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Projet;
import com.example.demo.entity.User;
import com.example.demo.respository.ProjetRepository;
import com.example.demo.service.PlanningProjetService;
import com.example.demo.service.ProjetService;
import com.example.demo.util.TypeProjetEnum;

@RestController
@RequestMapping("/crud_projet")
//@CrossOrigin
public class ProjetController extends CrudController<Projet, Long> {

	@Autowired
	private ProjetService projetService;

	@Autowired
	private ProjetRepository projetRepository;

	@RequestMapping("/Add")
	public ResponseEntity addPlanningProjet(@RequestBody HashMap<String, Object> mapper) {

		String title = ((String) mapper.get("title"));
		Integer idManager =  ((Integer) mapper.get("manager"));

		String typeprojet = ((String) mapper.get("typeProjet"));

		Projet projet = new Projet();
		projet.setTitle(title);
		User manager = new User();
		manager.setId(idManager.longValue());
		projet.setManager(manager);
			projet.setTypeProjet(TypeProjetEnum.valueOf(typeprojet));

		
		projetService.add(projet);

		return new ResponseEntity<>(HttpStatus.OK);

	}

	@RequestMapping(value = "/Update/{id}", method = RequestMethod.PUT)
	public ResponseEntity updatePlanningProjet(@RequestBody HashMap<String, Object> mapper, @PathVariable Long id) {

		String title = ((String) mapper.get("title"));
		Integer idManager =  ((Integer) mapper.get("manager"));
		// Long idProjet = Long.parseLong((String)mapper.get("id"));
		String typeprojet = ((String) mapper.get("typeProjet"));

		Projet projet = projetRepository.getOne(id);
		projet.setTitle(title);
		User manager = new User();
		manager.setId(idManager.longValue());
		projet.setManager(manager);
		projet.setTypeProjet(TypeProjetEnum.valueOf(typeprojet));

		projetService.update(projet);

		return new ResponseEntity<>(HttpStatus.OK);

	}

}
