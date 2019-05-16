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
import com.example.demo.util.RessourceEnum;
import com.example.demo.util.StatusEnum;
import com.example.demo.util.TypeActionEnum;

@RestController
@RequestMapping("/crud_sousaction")
//@CrossOrigin
public class SousActionController extends CrudController<SousAction, Long>{
	
	@Autowired
	SousActionService sActionService;
	
	@Autowired
	SousActionRepository sousActionRepository;

	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value = "/ASA/{id}", method = RequestMethod.POST)
	public ResponseEntity addSousAction(@RequestBody HashMap<String, Object> mapper, @PathVariable Integer id) {
		Integer idr = ((Integer) mapper.get("responsable"));

		
		String ressource = ((String) mapper.get("ressource"));
		String typeAction = ((String) mapper.get("typeAction"));
		String action = ((String) mapper.get("action"));

		User respo = userRepository.getOne(idr.longValue());
       SousAction sousAction = new SousAction();
       sousAction.setTypeAction(TypeActionEnum.valueOf(typeAction));
       sousAction.setRessource(RessourceEnum.valueOf(ressource));
       sousAction.setAction(action);
       sousAction.setResponsable(respo);
		sousAction.setActionProjetId(id);
		sActionService.add(sousAction);
		return new ResponseEntity<>(HttpStatus.OK);

		
	}
	
	@RequestMapping(value = "/USA/{id}", method = RequestMethod.PUT)
	public void CompleterSousAction(@RequestBody SousAction sousAction, @PathVariable Long id) {
		
		
		sActionService.updateSousAction(id, sousAction);
		

	}

}
