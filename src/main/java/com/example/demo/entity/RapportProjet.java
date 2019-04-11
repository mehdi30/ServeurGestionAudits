package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.example.demo.util.EfficaciteEnum;
import com.example.demo.util.TypeConstatEnum;

@Entity
public class RapportProjet {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
    private String activite;

    @Column(length = 1024)
    private String commentaire;
    
    @Enumerated(EnumType.STRING)
    private TypeConstatEnum typeConstat;
    
    @OnDelete(action=OnDeleteAction.CASCADE)
    @ManyToOne
    private Exigence exigence;
   
    private String libelle;

    
    
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


	


	public PlanningProjet getPlanningProjet() {
		return planningProjet;
	}


	public void setPlanningProjet(PlanningProjet planningProjet) {
		this.planningProjet = planningProjet;
	}


	public String getActivite() {
		return activite;
	}


	public void setActivite(String activite) {
		this.activite = activite;
	}


	public String getCommentaire() {
		return commentaire;
	}


	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}


	public TypeConstatEnum getTypeConstat() {
		return typeConstat;
	}


	public void setTypeConstat(TypeConstatEnum typeConstat) {
		this.typeConstat = typeConstat;
	}


	public Exigence getExigence() {
		return exigence;
	}


	public void setExigence(Exigence exigence) {
		this.exigence = exigence;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	

    
    


}
