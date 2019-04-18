package com.example.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
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
public class SousAction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "ACTIONPROJET_ID")
	private Integer actionProjetId;

	@Column(length = 1024)
	private String action;
	private LocalDateTime delai;
	private LocalDateTime dateEvaluation;
	private LocalDateTime dateRealisation;

	@Column(length = 1024)
	private String methode;
	@Column(length = 1024)
	private String commentaire;
	
	@Enumerated(EnumType.STRING)
	private TypeActionEnum typeAction;

	@Enumerated(EnumType.STRING)
	private RessourceEnum ressource;

	@Enumerated(EnumType.STRING)
	private StatusEnum status;

	@Enumerated(EnumType.STRING)
	private EfficaciteEnum efficacite;

	@ManyToOne
	private User responsable;

	public SousAction() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Integer getActionProjetId() {
		return actionProjetId;
	}

	public void setActionProjetId(Integer actionProjetId) {
		this.actionProjetId = actionProjetId;
	}

	public LocalDateTime getDelai() {
		return delai;
	}

	public void setDelai(LocalDateTime delai) {
		this.delai = delai;
	}

	public LocalDateTime getDateEvaluation() {
		return dateEvaluation;
	}

	public void setDateEvaluation(LocalDateTime dateEvaluation) {
		this.dateEvaluation = dateEvaluation;
	}

	public LocalDateTime getDateRealisation() {
		return dateRealisation;
	}

	public void setDateRealisation(LocalDateTime dateRealisation) {
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

	public User getResponsable() {
		return responsable;
	}

	public void setResponsable(User responsable) {
		this.responsable = responsable;
	}

	
}
