package com.example.demo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Ecart {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	
	private String nom;
	
	@OneToMany
	@JoinColumn(name = "ECART_ID", referencedColumnName = "id")
	private List<ActionProjet> actionProjet;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public List<ActionProjet> getActionProjet() {
		return actionProjet;
	}


	public void setActionProjet(List<ActionProjet> actionProjet) {
		this.actionProjet = actionProjet;
	}


	public Ecart() {
		super();
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	

}
