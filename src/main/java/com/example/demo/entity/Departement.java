package com.example.demo.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.example.demo.util.ProcessusEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Departement {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDep;
	
	@Enumerated(EnumType.STRING)
	private ProcessusEnum processus;

	private int effective;
	
	/* 
	@OneToMany(mappedBy="departement")
    private List<User> Employe;  */
	
	@JsonIgnore
	@OneToMany(mappedBy="departement",cascade = CascadeType.ALL)
    private List<PlanningProjet> planningProjet;

	private LocalDate date;
	public Departement() {
		super();
	}

	
	public Departement(ProcessusEnum processus) {
		super();
		this.processus = processus;
	}


	public Departement(ProcessusEnum processus, int effective) {
		super();
		this.processus = processus;
		this.effective = effective;
	}


	

	


/*
	public List<User> getEmploye() {
		return Employe;
	}


	public void setEmploye(List<User> employe) {
		Employe = employe;
	}*/


	

	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public int getEffective() {
		return effective;
	}


	public void setEffective(int effective) {
		this.effective = effective;
	}


	 


	public ProcessusEnum getProcessus() {
		return processus;
	}


	public void setProcessus(ProcessusEnum processus) {
		this.processus = processus;
	}


	public Long getIdDep() {
		return idDep;
	}


	public void setIdDep(Long idDep) {
		this.idDep = idDep;
	}


	public List<PlanningProjet> getPlanningProjet() {
		return planningProjet;
	}


	public void setPlanningProjet(List<PlanningProjet> planningProjet) {
		this.planningProjet = planningProjet;
	}


	

	


	
	
	
	
}
