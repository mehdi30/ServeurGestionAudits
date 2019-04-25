package com.example.demo.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.example.demo.util.EfficaciteEnum;
import com.example.demo.util.TypePlanningEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@IdClass(PlanningProjetPk.class)
public class PlanningProjet implements Serializable {

	/*
	 * @EmbeddedId private PlanningProjetPk planningProjetPk;
	 * 
	 */

	

	@Id
	private Long idAuditeur;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long numPlanning;

	
	private Long idProjet;
	
	private Long idAudite;

	private Long idDepartement;

	private LocalDateTime datePlan;

	private boolean etat = false;
	
    @Column(length = 1024)
	private String description;

	@Enumerated(EnumType.STRING)
    private TypePlanningEnum typePlanning;

	

	@ManyToOne // insertable=false,updatable=false c'est pas la responsabilite planning projet// d'ajouter ou màj l'auditeur
	@JoinColumn(name = "idAuditeur", referencedColumnName = "id", insertable = false, updatable = false)
	private User auditeur;

	@ManyToOne 
	@JoinColumn(name = "idAudite", referencedColumnName = "id", insertable = false, updatable = false)
	private User audite;
	
	@ManyToOne
	@JoinColumn(name = "idProjet", referencedColumnName = "id", insertable = false, updatable = false)
	private Projet projet;
	
	@ManyToOne
	@JoinColumn(name = "idDepartement", referencedColumnName = "idDep", insertable = false, updatable = false)
	private Departement departement;

	public PlanningProjet() {
		super();
	}

	public PlanningProjet(Audit audit, User auditeur) {
		super();
		this.auditeur = auditeur;

	}

	

	public User getAuditeur() {
		return auditeur;
	}

	public void setAuditeur(User auditeur) {
		this.auditeur = auditeur;
	}

	

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	

	public Long getIdAuditeur() {
		return idAuditeur;
	}

	public void setIdAuditeur(Long idAuditeur) {
		this.idAuditeur = idAuditeur;
	}

	public Long getNumPlanning() {
		return numPlanning;
	}

	public void setNumPlanning(Long numPlanning) {
		this.numPlanning = numPlanning;
	}

	/*public Long getIdProjet() {
		return idProjet;
	}

	public void setIdProjet(Long idProjet) {
		this.idProjet = idProjet;
	}*/

	public LocalDateTime getDatePlan() {
		return datePlan;
	}

	public void setDatePlan(LocalDateTime datePlan) {
		this.datePlan = datePlan;
	}

	public boolean isEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	public Long getIdProjet() {
		return idProjet;
	}

	public void setIdProjet(Long idProjet) {
		this.idProjet = idProjet;
	}

	public Long getIdDepartement() {
		return idDepartement;
	}

	public void setIdDepartement(Long idDepartement) {
		this.idDepartement = idDepartement;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TypePlanningEnum getTypePlanning() {
		return typePlanning;
	}

	public void setTypePlanning(TypePlanningEnum typePlanning) {
		this.typePlanning = typePlanning;
	}

	public Long getIdAudite() {
		return idAudite;
	}

	public void setIdAudite(Long idAudite) {
		this.idAudite = idAudite;
	}

	public User getAudite() {
		return audite;
	}

	public void setAudite(User audite) {
		this.audite = audite;
	}

	///////////////////////////////////
	
	

}
