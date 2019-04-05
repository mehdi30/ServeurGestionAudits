package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Audit {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    private String procedures;
    
    @JsonIgnore 
    @OneToMany(mappedBy="audit",cascade = CascadeType.ALL)
    private List<PlanningProjet> planningProjets;
    
    
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<PlanningProjet> getPlanningProjets() {
		return planningProjets;
	}
	public void setPlanningProjets(List<PlanningProjet> planningProjets) {
		this.planningProjets = planningProjets;
	}
	
	public Audit() {
		super();
	}
	public String getProcedures() {
		return procedures;
	}
	public void setProcedures(String procedures) {
		this.procedures = procedures;
	}
	
	public Audit(String procedures) {
		super();
		this.procedures = procedures;
	}
	
    
    
}
