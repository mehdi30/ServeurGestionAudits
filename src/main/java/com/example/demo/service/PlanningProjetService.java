package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PlanningProjet;
import com.example.demo.entity.PlanningProjetPk;
import com.example.demo.entity.SousAction;
import com.example.demo.entity.User;
import com.example.demo.respository.PlanningProjetRepository;
import com.example.demo.respository.UserRepository;
import com.example.demo.service.interfaces.IPlanningProjet;
import com.example.demo.util.TypePlanningEnum;

@Service
@Primary
public class PlanningProjetService implements ICrudService<PlanningProjet, Long>,IPlanningProjet{

	@Autowired
	PlanningProjetRepository planningProjetRepository;
	
	@Autowired
	UserRepository userRepository;
	@Override
	public List<PlanningProjet> getAll() {
		return planningProjetRepository.findAll();
	}
	
	@Override
	public PlanningProjet getPlanningByNumPlanning(Long num) {
		return planningProjetRepository.findByNumPlanning(num);
	}
	@Override
	public void add(PlanningProjet entity) {
		planningProjetRepository.save(entity)	;	
	}

	@Override
	public void update(PlanningProjet entity) {
		planningProjetRepository.save(entity)	;	
		
	}

	@Override
	public void delete(Long numPlanning) {

		PlanningProjet plan = new PlanningProjet();
		plan.setNumPlanning(numPlanning);
		planningProjetRepository.delete(plan);
	}

	@Override
	public List<PlanningProjet> getAllPlanifie() {
		return planningProjetRepository.findAllPlanifie();
	}

	@Override
	public List<PlanningProjet> getAllRealise() {
		return planningProjetRepository.findAllRealise();
	}
	
	public void updatePlanningProjet(Long id, HashMap<String, Object> mapper) {
		String description = ((String) mapper.get("description"));
		String typePlanning = ((String) mapper.get("typePlanning"));
		Integer idp = ((Integer) mapper.get("projet"));
		ArrayList<Integer> la = (ArrayList<Integer>) (mapper.get("audite"));

		ArrayList<Integer> l = (ArrayList<Integer>) (mapper.get("user"));

		LocalDateTime datePlan = LocalDateTime.parse((String) mapper.get("datePlan"));
		List<User> lista = new ArrayList<User>();
		List<User> list = new ArrayList<User>();

		try {
			PlanningProjet s = planningProjetRepository.findByNumPlanning(id);
			
			
			
			if(s!= null) {
				PlanningProjet obj = s;
				obj.setDescription(description);
				obj.setDatePlan(datePlan);
				obj.setIdProjet(idp.longValue());
				obj.setTypePlanning(TypePlanningEnum.valueOf(typePlanning));

				

				for (Integer i = 0; i < la.size(); i++) {
					if (!String.valueOf(la.get(i)).equals("")) {

					
						User audite = userRepository.getOne(la.get(i).longValue());
						lista.add(audite);

					}

				}
				obj.setAudites(lista);
				

				for (Integer i = 0; i < l.size(); i++) {

					if (!String.valueOf(l.get(i)).equals("")) {

					
						User auditeur = userRepository.getOne(l.get(i).longValue());
						list.add(auditeur);

					}

				}
				obj.setAuditeurs(list);

				planningProjetRepository.save(obj);
			}
		}catch (Exception e) {
			//logger.error(e.getMessage());
		}
	}

	public void updatePlanningDepartement(Long id, HashMap<String, Object> mapper) {
		String description = ((String) mapper.get("description"));
		String typePlanning = ((String) mapper.get("typePlanning"));
		Integer idp = ((Integer) mapper.get("departement"));
		ArrayList<Integer> la = (ArrayList<Integer>) (mapper.get("audite"));

		ArrayList<Integer> l = (ArrayList<Integer>) (mapper.get("user"));

		LocalDateTime datePlan = LocalDateTime.parse((String) mapper.get("datePlan"));
		List<User> lista = new ArrayList<User>();
		List<User> list = new ArrayList<User>();

		try {
			PlanningProjet s = planningProjetRepository.findByNumPlanning(id);
			
			
			
			if(s!= null) {
				PlanningProjet obj = s;
				obj.setDescription(description);
				obj.setDatePlan(datePlan);
				obj.setIdDepartement(idp.longValue());
				obj.setTypePlanning(TypePlanningEnum.valueOf(typePlanning));

				

				for (Integer i = 0; i < la.size(); i++) {
					if (!String.valueOf(la.get(i)).equals("")) {

					
						User audite = userRepository.getOne(la.get(i).longValue());
						lista.add(audite);

					}

				}
				obj.setAudites(lista);
				

				for (Integer i = 0; i < l.size(); i++) {

					if (!String.valueOf(l.get(i)).equals("")) {

					
						User auditeur = userRepository.getOne(l.get(i).longValue());
						list.add(auditeur);

					}

				}
				obj.setAuditeurs(list);

				planningProjetRepository.save(obj);
			}
		}catch (Exception e) {
			//logger.error(e.getMessage());
		}
	}

}
