package com.example.demo.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ActionProjet;
import com.example.demo.entity.SousAction;
import com.example.demo.respository.ActionProjetRepository;
import com.example.demo.respository.SousActionRepository;
import com.example.demo.service.interfaces.IActionProjet;
import com.example.demo.util.StatusEnum;

@Service
@Primary
public class ActionProjetService implements  ICrudService<ActionProjet, Long>,IActionProjet{

	@Autowired
	ActionProjetRepository actionProjetRepository;
	
	@Autowired
	SousActionRepository sousActionProjetRepository;
	@Override
	public void updateActionProjet(Long id, ActionProjet c) {
		try {
			ActionProjet a = actionProjetRepository.getOne(id);
			if(a!= null) {
				ActionProjet obj = a;
			
				LocalDateTime currentDate = LocalDateTime.now();

				actionProjetRepository.save(obj);
			}
		}catch (Exception e) {
		}
	}
	
	@Override
	public List<ActionProjet> getAll() {
		return actionProjetRepository.findAll();
	}

	@Override
	public void add(ActionProjet entity) {
		actionProjetRepository.save(entity);
	}

	@Override
	public void update(ActionProjet entity) {
		actionProjetRepository.save(entity);		
	}

	@Override
	public void delete(Long id) {
	}

}
