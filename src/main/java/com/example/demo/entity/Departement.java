package com.example.demo.entity;

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


@Entity
public class Departement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private ProcessusEnum processus;

	private int effective;
	
	  
    @JsonIgnore 
	@OneToMany(mappedBy="departement")
    private List<User> Employe;  
	
    @JsonIgnore 
	@OneToMany(mappedBy="departement",cascade = CascadeType.ALL)
    private List<PlanningDepart> planningDepart;

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


	public Departement(Long id, ProcessusEnum processus) {
		super();
		this.id = id;
		this.processus = processus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	



	public List<User> getEmploye() {
		return Employe;
	}


	public void setEmploye(List<User> employe) {
		Employe = employe;
	}


	public List<PlanningDepart> getPlanningDepart() {
		return planningDepart;
	}


	public void setPlanningDepart(List<PlanningDepart> planningDepart) {
		this.planningDepart = planningDepart;
	}


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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departement other = (Departement) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Departement [id=" + id + ", processus=" + processus + "]";
	}

	
	
	
}
