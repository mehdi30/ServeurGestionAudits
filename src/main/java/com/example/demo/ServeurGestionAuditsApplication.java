package com.example.demo;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ConditionalOnEnabledResourceChain;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Audit;
import com.example.demo.entity.Departement;
import com.example.demo.entity.PlanningProjet;
import com.example.demo.entity.PlanningProjetPk;
import com.example.demo.entity.Produit;
import com.example.demo.entity.Projet;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.respository.AuditRepository;
import com.example.demo.respository.DepartementRepository;
import com.example.demo.respository.PlanningProjetRepository;
import com.example.demo.respository.ProduitRepository;
import com.example.demo.respository.ProjetRepository;
import com.example.demo.respository.RoleRepository;
import com.example.demo.respository.UserRepository;
import com.example.demo.util.ProcessusEnum;
import com.example.demo.util.RoleEnum;

@SpringBootApplication
public class ServeurGestionAuditsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(ServeurGestionAuditsApplication.class, args);

	/*ProduitRepository produitRepository = ctx.getBean(ProduitRepository.class);
		
	produitRepository.save(new Produit("Livre", 50, 20));
	produitRepository.save(new Produit("Cahier", 200, 5.25f));	
	produitRepository.save(new Produit("Stylo", 500, 2.10f));	
	
	
	
	DepartementRepository departementRepository = ctx.getBean(DepartementRepository.class);
	
	departementRepository.save(new Departement(ProcessusEnum.Technique,54));
	departementRepository.save(new Departement(ProcessusEnum.Administrative, 55));

	   
	  
	
		
		RoleRepository roleRepository = ctx.getBean(RoleRepository.class);

		Role roleUser = new Role(RoleEnum.ROLE_USER);
		Role roleAdmin = new Role(RoleEnum.ROLE_ADMIN);

		roleRepository.save(roleUser);
		roleRepository.save(roleAdmin);
		
		UserRepository userRepository = ctx.getBean(UserRepository.class);

		User user = new User("user", "password1", true);
		user.setRoles(Arrays.asList(roleUser));

		userRepository.save(user);

		User admin = new User("admin", "password2", true);
		admin.setRoles(Arrays.asList(roleUser, roleAdmin));
		userRepository.save(admin);
		
		
		  ProjetRepository projetRepository = ctx.getBean(ProjetRepository.class);
		    Projet projet = new Projet("haha");
		    projet.setManager(admin);
		    projetRepository.save(projet);
		
		
		AuditRepository auditRepository = ctx.getBean(AuditRepository.class);
		Audit audit = new  Audit("procedures");
		Audit audit1 = new  Audit("procedures");

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
