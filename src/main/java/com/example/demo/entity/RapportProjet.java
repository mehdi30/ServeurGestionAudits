package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class RapportProjet {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
    private String contexte;
    private String force;
    private String risque;
    private String amélioration;
    private String conclusion;
    
    
    @ManyToOne
    private PlanningProjet planningProjet;


	public RapportProjet() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getContexte() {
		return contexte;
	}


	public void setContexte(String contexte) {
		this.contexte = contexte;
	}


	public String getForce() {
		return force;
	}


	public void setForce(String force) {
		this.force = force;
	}


	public String getRisque() {
		return risque;
	}


	public void setRisque(String risque) {
		this.risque = risque;
	}


	public String getAmélioration() {
		return amélioration;
	}


	public void setAmélioration(String amélioration) {
		this.amélioration = amélioration;
	}


	public String getConclusion() {
		return conclusion;
	}


	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}


	public PlanningProjet getPlanningProjet() {
		return planningProjet;
	}


	public void setPlanningProjet(PlanningProjet planningProjet) {
		this.planningProjet = planningProjet;
	}


	

    
    


}
