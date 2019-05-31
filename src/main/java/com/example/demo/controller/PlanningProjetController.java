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

import com.example.demo.entity.Departement;
import com.example.demo.entity.Notification;
import com.example.demo.entity.PlanningProjet;
import com.example.demo.entity.PlanningProjetPk;
import com.example.demo.entity.Projet;
import com.example.demo.entity.RapportProjet;
import com.example.demo.entity.SousAction;
import com.example.demo.entity.User;
import com.example.demo.respository.DepartementRepository;
import com.example.demo.respository.PlanningProjetRepository;
import com.example.demo.respository.ProjetRepository;
import com.example.demo.respository.UserRepository;
import com.example.demo.service.NotificationService;
import com.example.demo.service.PlanningProjetService;
import com.example.demo.service.ProjetService;
import com.example.demo.util.EtatPlanningEnum;
import com.example.demo.util.TypePlanningEnum;

@RestController
@RequestMapping("/Planning_Projet")
// @CrossOrigin
public class PlanningProjetController extends CrudController<PlanningProjet, Long> {

	@Autowired
	private PlanningProjetService planningProjetService;
	@Autowired
	private ProjetRepository projetRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PlanningProjetRepository planningProjetRepository;

	@Autowired
	RegistrationController registerController;
	
	@Autowired
	private DepartementRepository departementRepository;

	@Autowired
	NotificationService notificationService;

	@RequestMapping(value = "/s/{numPlanning}", method = RequestMethod.DELETE)
	public void deletebynum(@PathVariable Long numPlanning) {

		planningProjetService.delete(numPlanning);

	}

	@RequestMapping("/List/Planifie")
	public List<PlanningProjet> AllPlanifie() {
		return planningProjetService.findAllOrderBydate();
		//return planningProjetService.getAll();

	}

	/*
	 * @RequestMapping("/List/Realise") public List<PlanningProjet> AllRealise() {
	 * return planningProjetService.getAllRealise();
	 * 
	 * }
	 */

	@RequestMapping(value = "/Add", method = RequestMethod.POST)
	public ResponseEntity addPlanningProjet(@RequestBody HashMap<String, Object> mapper) {

		LocalDateTime datePlan = LocalDateTime.parse((String) mapper.get("datePlan"));
		Long idProjet = Long.parseLong((String) mapper.get("projet"));
		String description = ((String) mapper.get("description"));
		String typePlanning = ((String) mapper.get("typePlanning"));
		ArrayList<Integer> l = (ArrayList<Integer>) (mapper.get("user"));
		ArrayList<Integer> la = (ArrayList<Integer>) (mapper.get("audite"));

		Projet projet = projetRepository.getOne(idProjet);

		PlanningProjet planningProjet = new PlanningProjet();
		

		List<User> list = new ArrayList<User>();

		for (Integer i = 0; i < l.size(); i++) {
			if (!String.valueOf(l.get(i)).equals("")) {

				User auditeur = userRepository.getOne(l.get(i).longValue());
				list.add(auditeur);

			}

		}
		planningProjet.setAuditeurs(list);

		List<User> lista = new ArrayList<User>();

		for (Integer i = 0; i < la.size(); i++) {
			if (!String.valueOf(la.get(i)).equals("")) {

				User audite = userRepository.getOne(la.get(i).longValue());
				lista.add(audite);

			}

		}
		planningProjet.setAudites(lista);

		planningProjet.setIdProjet(idProjet);

		planningProjet.setDescription(description);

		planningProjet.setTypePlanning(TypePlanningEnum.valueOf(typePlanning));

		planningProjet.setStart(datePlan);
		planningProjet.setEtatPlanning(EtatPlanningEnum.Planifié);

		planningProjetService.add(planningProjet);

		planningProjet.setTitle("N° " + planningProjet.getNumPlanning() + " " + projet.getTitle() + " "
				+ projet.getTypeProjet().getName());
		planningProjet.setClassName("event-red");
		
		planningProjetService.update(planningProjet);
		LocalDateTime currentDate = LocalDateTime.now();

		Notification notif = new Notification();
		notif.setDateNot(currentDate);
		String t = "Audit projet "+ projet.getTitle() +" a été planifié pour le " + datePlan;
		

		notif.setTitle(t);
		for (User audite : lista) {
			notif.setUser(audite);

			String maudite = "Bonjour" + " " + audite.getUsername()+", \n \n" +  "Audit projet "+ projet.getTitle() +" a été planifié pour le " + datePlan + " "
					+ "\n"+ " - Numéro de l'audit : " + planningProjet.getNumPlanning() + "  \n" + 
					"Cordialement.";
			notificationService.add(notif);
			registerController.sendMails(audite.getEmail(), "Audit Projet Planifié", maudite);
		}
		for (User auditeur : list) {
			notif.setUser(auditeur);

			String maudite = "Bonjour" + " " + auditeur.getUsername()+", \n \n" +  "vous êtes chargé de faire" + " " + "l'audit projet "+ projet.getTitle() +" qui a été planifié pour le " + datePlan + " "
					+ "\n"+ " - Numéro de l'audit : " + planningProjet.getNumPlanning() + "  \n" + 
					"Cordialement.";
			notificationService.add(notif);
			registerController.sendMails(auditeur.getEmail(), "Audit Projet Planifié", maudite);
			}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/AddD", method = RequestMethod.POST)
	public ResponseEntity addPlanningDepartement(@RequestBody HashMap<String, Object> mapper) {

		Long idDep = Long.parseLong((String) mapper.get("departement"));
		Departement d = departementRepository.getOne(idDep);
		ArrayList<Integer> la = (ArrayList<Integer>) (mapper.get("audite"));
		String description = ((String) mapper.get("description"));

		ArrayList<Integer> l = (ArrayList<Integer>) (mapper.get("user"));

		LocalDateTime datePlan = LocalDateTime.parse((String) mapper.get("datePlan"));
		String typePlanning = ((String) mapper.get("typePlanning"));

		PlanningProjet planningProjet = new PlanningProjet();
		List<User> list = new ArrayList<User>();

		for (Integer i = 0; i < l.size(); i++) {

			if (!String.valueOf(l.get(i)).equals("")) {

				User auditeur = userRepository.getOne(l.get(i).longValue());
				list.add(auditeur);

			}

		}
		planningProjet.setAuditeurs(list);

		planningProjet.setIdDepartement(idDep);

		planningProjet.setTypePlanning(TypePlanningEnum.valueOf(typePlanning));

		planningProjet.setDescription(description);
		planningProjet.setClassName("event-red");
		List<User> lista = new ArrayList<User>();

		for (Integer i = 0; i < la.size(); i++) {
			if (!String.valueOf(la.get(i)).equals("")) {

				User auditeur = userRepository.getOne(la.get(i).longValue());
				lista.add(auditeur);

			}

		}
		planningProjet.setAudites(lista);

		planningProjet.setStart(datePlan);

		planningProjet.setEtatPlanning(EtatPlanningEnum.Planifié);

		planningProjetService.add(planningProjet);
		planningProjet.setTitle("N° " + planningProjet.getNumPlanning() + " " + d.getProcessus().getName());

		planningProjetService.update(planningProjet);

		LocalDateTime currentDate = LocalDateTime.now();

		Notification notif = new Notification();
		notif.setDateNot(currentDate);
		String t = "Audit Process " + d.getProcessus() + " a été planifié pour le " + datePlan;
		notif.setTitle(t);
		for (User audite : lista) {
			notif.setUser(audite);

			notificationService.add(notif);
		}
		for (User audite : list) {
			notif.setUser(audite);

			notificationService.add(notif);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/details/{numPlanning}", method = RequestMethod.GET)
	public PlanningProjet getPlanningByNumPlanning(@PathVariable Long numPlanning) {

		return planningProjetService.getPlanningByNumPlanning(numPlanning);

	}

	@RequestMapping(value = "/UPlanningP/{id}", method = RequestMethod.PUT)
	public void updatePlanningProjet(@RequestBody HashMap<String, Object> mapper, @PathVariable Long id) {

		planningProjetService.updatePlanningProjet(id, mapper);

	}

	@RequestMapping(value = "/UPlanningD/{id}", method = RequestMethod.PUT)
	public void updatePlanningDepartement(@RequestBody HashMap<String, Object> mapper, @PathVariable Long id) {

		planningProjetService.updatePlanningDepartement(id, mapper);

	}

	@RequestMapping(value = "/Annuler/{numPlanning}", method = RequestMethod.PUT)
	public void annulerPlanning(@RequestBody PlanningProjet planningP, @PathVariable Long numPlanning) {

		PlanningProjet a = planningProjetRepository.findByNumPlanning(numPlanning);
		a.setEtat(true);

		planningProjetService.update(a);

	}

	@RequestMapping(value = "/Valider/{numPlanning}", method = RequestMethod.PUT)
	public void ValiderPlanning(@RequestBody PlanningProjet planningP, @PathVariable Long numPlanning) {

		PlanningProjet a = planningProjetRepository.findByNumPlanning(numPlanning);
		a.setEtat(false);
		a.setEtatPlanning(EtatPlanningEnum.Planifié);

		planningProjetService.update(a);

	}

	@RequestMapping(value = "/counts", method = RequestMethod.GET)
	public List<PlanningProjet> countByMonths() {

		return planningProjetService.countByMonths();

	}

	@RequestMapping(value = "/counte/{e}", method = RequestMethod.GET)
	public long countByEtatPlanning(@PathVariable String e) {

		return planningProjetService.countByEtatPlanning(EtatPlanningEnum.valueOf(e));

	}

}
