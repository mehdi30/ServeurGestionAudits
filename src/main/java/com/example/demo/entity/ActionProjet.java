package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.example.demo.util.EfficaciteEnum;
import com.example.demo.util.RessourceEnum;
import com.example.demo.util.StatusEnum;
import com.example.demo.util.TypeActionEnum;

@Entity
public class ActionProjet {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
    private String contexte;
    private String action;
	private LocalDate delai;
	private LocalDate dateEvaluation;
	private LocalDate dateRealisation;
    private String methode;
    private String commentaire;
    private Long numero;


	@Enumerated(EnumType.STRING)
    private TypeActionEnum typeAction;

	@Enumerated(EnumType.STRING)
    private RessourceEnum ressource;
	
	@Enumerated(EnumType.STRING)
    private StatusEnum status;

	@Enumerated(EnumType.STRING)
    private EfficaciteEnum efficacite;
	
    @ManyToOne
    private PlanningProjet planningProjet;


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


	public PlanningProjet getPlanningProjet() {
		return planningProjet;
	}


	public void setPlanningProjet(PlanningProjet planningProjet) {
		this.planningProjet = planningProjet;
	}


	public ActionProjet() {
		super();
	}



	public TypeActionEnum getTypeAction() {
		return typeAction;
	}


	public void setTypeAction(TypeActionEnum typeAction) {
		this.typeAction = typeAction;
	}


	public RessourceEnum getRessource() {
		return ressource;
	}


	public void setRessource(RessourceEnum ressource) {
		this.ressource = ressource;
	}


	public StatusEnum getStatus() {
		return status;
	}


	public void setStatus(StatusEnum status) {
		this.status = status;
	}


	public EfficaciteEnum getEfficacite() {
		return efficacite;
	}


	public void setEfficacite(EfficaciteEnum efficacite) {
		this.efficacite = efficacite;
	}


	public String getAction() {
		return action;
	}


	public void setAction(String action) {
		this.action = action;
	}


	public LocalDate getDelai() {
		return delai;
	}


	public void setDelai(LocalDate delai) {
		this.delai = delai;
	}


	public LocalDate getDateEvaluation() {
		return dateEvaluation;
	}


	public void setDateEvaluation(LocalDate dateEvaluation) {
		this.dateEvaluation = dateEvaluation;
	}


	public LocalDate getDateRealisation() {
		return dateRealisation;
	}


	public void setDateRealisation(LocalDate dateRealisation) {
		this.dateRealisation = dateRealisation;
	}


	public String getMethode() {
		return methode;
	}


	public void setMethode(String methode) {
		this.methode = methode;
	}


	public String getCommentaire() {
		return commentaire;
	}


	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}


	public Long getNumero() {
		return numero;
	}


	public void setNumero(Long numero) {
		this.numero = numero;
	}


	
    
    
    

}
