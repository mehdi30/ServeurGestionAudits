package com.example.demo.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@IdClass(PlanningProjetPk.class)
public class PlanningProjet implements Serializable {

	/*
	 * @EmbeddedId private PlanningProjetPk planningProjetPk;
	 * 
	 */

	@Id
	private Long idAudit;

	@Id
	private Long idAuditeur;

	// @Id
	// @Column(name = "ETAPA_ID", columnDefinition = "uuid")
	// @Type(type = "org.hibernate.type.PostgresUUIDType")
	// @GenericGenerator(name = "uuid2", strategy = "uuid2")
	// @GeneratedValue(generator = "uuid2")
	// private UUID id;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long numPlanning;

	
	private Long idProjet;

	private Long idDepartement;

	private LocalDate datePlan;

	private boolean etat = false;

	@ManyToOne
	@JoinColumn(name = "idAudit", referencedColumnName = "id", insertable = false, updatable = false)
	private Audit audit;

	@ManyToOne // insertable=false,updatable=false c'est pas la responsabilite planning projet// d'ajouter ou màj l'auditeur
	@JoinColumn(name = "idAuditeur", referencedColumnName = "id", insertable = false, updatable = false)
	private User auditeur;

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
		this.audit = audit;
		this.auditeur = auditeur;

	}

	public Audit getAudit() {
		return audit;
	}

	public void setAudit(Audit audit) {
		this.audit = audit;
	}

	public User getAuditeur() {
		return auditeur;
	}

	public void setAuditeur(User auditeur) {
		this.auditeur = auditeur;
	}

	/*
	 * public PlanningProjetPk getPlanningProjetPk() { return planningProjetPk; }
	 * 
	 * public void setPlanningProjetPk(PlanningProjetPk planningProjetPk) {
	 * this.planningProjetPk = planningProjetPk; }
	 */

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public Long getIdAudit() {
		return idAudit;
	}

	public void setIdAudit(Long idAudit) {
		this.idAudit = idAudit;
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

	public LocalDate getDatePlan() {
		return datePlan;
	}

	public void setDatePlan(LocalDate datePlan) {
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

	///////////////////////////////////
	
	

}
