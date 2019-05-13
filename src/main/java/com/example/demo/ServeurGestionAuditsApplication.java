package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ConditionalOnEnabledResourceChain;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ActionProjet;
import com.example.demo.entity.Audit;
import com.example.demo.entity.Departement;
import com.example.demo.entity.PlanningProjet;
import com.example.demo.entity.PlanningProjetPk;
import com.example.demo.entity.Projet;
import com.example.demo.entity.Role;
import com.example.demo.entity.SousAction;
import com.example.demo.entity.User;
import com.example.demo.respository.ActionProjetRepository;
import com.example.demo.respository.AuditRepository;
import com.example.demo.respository.DepartementRepository;
import com.example.demo.respository.PlanningProjetRepository;
import com.example.demo.respository.ProjetRepository;
import com.example.demo.respository.RoleRepository;
import com.example.demo.respository.SousActionRepository;
import com.example.demo.respository.UserRepository;
import com.example.demo.util.ProcessusEnum;
import com.example.demo.util.RoleEnum;
import com.example.demo.util.TypeProjetEnum;

@SpringBootApplication
public class ServeurGestionAuditsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(ServeurGestionAuditsApplication.class, args);

	

		/*ActionProjetRepository actionr = ctx.getBean(ActionProjetRepository.class);
		SousActionRepository sactionr = ctx.getBean(SousActionRepository.class);
		SousAction saction = new SousAction();
		saction.setAction("haha");
		sactionr.save(saction);

		SousAction saction2 = new SousAction();
		saction2.setAction("tddd!!");
		sactionr.save(saction2);
		
		List<ActionProjet> actions = actionr.findAll();
		actions.forEach(action -> action.setSousActions(Arrays.asList(saction)));
		actions.forEach(action2 -> action2.setSousActions(Arrays.asList(saction2)));

		actions.forEach(action -> actionr.save(action));

		
		
		//action.setSousActions(Arrays.asList(saction));
		*/ /*
		
		
	DepartementRepository departementRepository = ctx.getBean(DepartementRepository.class);
	Departement d = new Departement(ProcessusEnum.Technique,"lac 2");
	departementRepository.save(d);
	departementRepository.save(new Departement(ProcessusEnum.Administrative, "pole"));

	   
	  
	
		
		RoleRepository roleRepository = ctx.getBean(RoleRepository.class);

		Role roleUser = new Role(RoleEnum.ROLE_USER);
		Role roleAdmin = new Role(RoleEnum.ROLE_ADMIN);

		roleRepository.save(roleUser);
		roleRepository.save(roleAdmin);
		
		UserRepository userRepository = ctx.getBean(UserRepository.class);

		User user = new User("Hanen", "password1", true);
		user.setLastname("Chakroun");
		user.setRoles(Arrays.asList(roleUser));
        user.setDepartement(d);
		userRepository.save(user);
		
		User user1 = new User("Farah", "password1", true);
		user1.setLastname("Krichen");
        user1.setDepartement(d);

		user1.setRoles(Arrays.asList(roleUser));

		userRepository.save(user1);

		User admin = new User("Mehdi", "password2", true);
		admin.setLastname("Gaies");
        admin.setDepartement(d);

		admin.setRoles(Arrays.asList(roleUser, roleAdmin));
		userRepository.save(admin);
		
		
		  ProjetRepository projetRepository = ctx.getBean(ProjetRepository.class);
		    Projet projet = new Projet("Dev 01");
		    projet.setManager(user1);
		    projet.setTypeProjet(TypeProjetEnum.TMA);
		    projetRepository.save(projet);
		
		
		AuditRepository auditRepository = ctx.getBean(AuditRepository.class);
		Audit audit = new  Audit("SWOT W1");
		Audit audit1 = new  Audit("SWOT W2");

		auditRepository.save(audit);
		auditRepository.save(audit1);

		/*
		PlanningProjetRepository planningProjetRepository = ctx.getBean(PlanningProjetRepository.class);

		PlanningProjet plan1 = new PlanningProjet();
		planningProjetRepository.save(plan1);
		admin.setPlanningProjets(Arrays.asList(plan1));
		userRepository.save(admin);

	
		
		PlanningProjetPk planningProjetPk = new PlanningProjetPk();

		planningProjetPk.setIdAudit(audit.getId());
		planningProjetPk.setIdAuditeur(admin.getId());
		
		
		PlanningProjet planningProjet = new PlanningProjet();
		planningProjet.setAudit(audit1);
		planningProjet.setAuditeur(user);
		planningProjet.setNumPlanning(2l);
		planningProjetRepository.save(planningProjet);
		
		
		PlanningProjetPk planningProjetPk2 = new PlanningProjetPk();

		
		planningProjetPk2.setIdAudit(audit.getId());
		planningProjetPk2.setIdAuditeur(admin.getId());
		
		PlanningProjet planningProjet1 = new PlanningProjet();
		planningProjet1.setPlanningProjetPk(planningProjetPk2);

		planningProjetRepository.save(planningProjet1);*/
		
		}
	
	

	
	
}
