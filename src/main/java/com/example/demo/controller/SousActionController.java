package com.example.demo.controller;

import java.time.LocalDateTime;
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

import com.example.demo.entity.ActionProjet;
import com.example.demo.entity.SousAction;
import com.example.demo.entity.User;
import com.example.demo.respository.ActionProjetRepository;
import com.example.demo.respository.SousActionRepository;
import com.example.demo.respository.UserRepository;
import com.example.demo.service.ActionProjetService;
import com.example.demo.service.SousActionService;
import com.example.demo.util.EfficaciteEnum;
import com.example.demo.util.StatusEnum;

@RestController
@RequestMapping("/crud_sousaction")
@CrossOrigin
public class SousActionController extends CrudController<SousAction, Long>{
	
	@Autowired
	SousActionService sActionService;
	
	@Autowired
	SousActionRepository sousActionRepository;

	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value = "/ASA/{id}", method = RequestMethod.POST)
	public ResponseEntity addSousAction(@RequestBody SousAction sousAction, @PathVariable Integer id) {
		
		sousAction.setActionProjetId(id);
		sActionService.add(sousAction);
		return new ResponseEntity<>(HttpStatus.OK);

		
	}
	
	@RequestMapping(value = "/USA/{id}", method = RequestMethod.PUT)
	public void CompleterSousAction(@RequestBody SousAction sousAction, @PathVariable Long id) {
		
		/*String methode = ((String) mapper.get("methode"));
		String status = ((String) mapper.get("status"));
		String efficacite = ((String) mapper.get("efficacite"));
		LocalDateTime dateEvaluation = LocalDateTime.parse((String)mapper.get("dateEvaluation"));
		LocalDateTime delai = LocalDateTime.parse((String)mapper.get("delai"));
		LocalDateTime dateRealisation = LocalDateTime.parse((String)mapper.get("dateRealisation"));
		Long idr = Long.parseLong((String) mapper.get("responsable"));
		String commentaire = ((String) mapper.get("commentaire"));

		SousAction sAction = sousActionRepository.getOne(id);
		User resp = userRepository.getOne(idr);
		sAction.setMethode(methode);
		sAction.setStatus(StatusEnum.valueOf(status));
		sAction.setEfficacite(EfficaciteEnum.valueOf(efficacite));
		sAction.setDateEvaluation(dateEvaluation);
		sAction.setDelai(delai);
		sAction.setDateRealisation(dateRealisation);
		sAction.setResponsable(resp);
		sAction.setCommentaire(commentaire);*/
		sActionService.updateSousAction(id, sousAction);
		

	}

}
