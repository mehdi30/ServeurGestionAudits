package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ActionProjet;
import com.example.demo.entity.SousAction;
import com.example.demo.entity.User;
import com.example.demo.respository.SousActionRepository;
import com.example.demo.respository.UserRepository;

@Service
@Primary
public class SousActionService implements ICrudService<SousAction, Long>{

	@Autowired
	SousActionRepository sousActionRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<SousAction> getAll() {
		return sousActionRepository.findAll();
	}

	@Override
	public void add(SousAction entity) {
		sousActionRepository.save(entity);		
	}

	@Override
	public void update(SousAction entity) {
		sousActionRepository.save(entity);		
		
	}
	public void updateSousAction(Long id, SousAction c) {
		// TODO Auto-generated method stub
		try {
			SousAction s = sousActionRepository.getOne(id);
			//User u = userRepository.getOne(idrespo);
			if(s!= null) {
				SousAction obj = s;
				obj.setMethode(c.getMethode());
				obj.setCommentaire(c.getCommentaire());
				obj.setStatus(c.getStatus());
				obj.setEfficacite(c.getEfficacite());
				obj.setDelai(c.getDelai());
				obj.setDateRealisation(c.getDateRealisation());
				//obj.setNumero(c.getNumero());
				obj.setDateEvaluation(c.getDateEvaluation());

				//obj.setResponsable(u);
				//LocalDateTime currentDate = LocalDateTime.now();
             

				sousActionRepository.save(obj);
			}
		}catch (Exception e) {
			//logger.error(e.getMessage());
		}
	}

	@Override
	public void delete(Long id) {
         SousAction s = new SousAction();
         s.setId(id);
         sousActionRepository.delete(s);
	}

}
