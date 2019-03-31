package com.example.demo.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
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
@IdClass(PlanningDepartPk.class)
public class PlanningDepart {

	/*
	 * @EmbeddedId private PlanningDepartPk planningDepartPk;
	 */

	@Id
	private Long idAudit;

	@Id
	private Long idAuditeur;

	@Id
	private Long idAudite;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long numPlanning;

	@Id
	private Long idDepartement;

	
	@ManyToOne
	@JoinColumn(name = "idAudit", referencedColumnName = "id", insertable = false, updatable = false)
	private Audit audit;

	
	@ManyToOne // insertable=false,updatable=false c'est pas la responsabilite planning projet
				// d'ajouter ou màj l'auditeur
	@JoinColumn(name = "idAuditeur", referencedColumnName = "id", insertable = false, updatable = false)
	private User auditeur;

	
	@ManyToOne // insertable=false,updatable=false c'est pas la responsabilite planning projet
				// d'ajouter ou màj l'auditeur
	@JoinColumn(name = "idAudite", referencedColumnName = "id", insertable = false, updatable = false)
	private User audite;

	
	@ManyToOne
	@JoinColumn(name = "idDepartement", referencedColumnName = "idDep", insertable = false, updatable = false)
	private Departement departement;

	public PlanningDepart() {
		super();
	}

	/*
	 * public PlanningDepartPk getPlanningDepartPk() { return planningDepartPk; }
	 * 
	 * 
	 * public void setPlanningDepartPk(PlanningDepartPk planningDepartPk) {
	 * this.planningDepartPk = planningDepartPk; }
	 */

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

	public Long getIdAudite() {
		return idAudite;
	}

	public void setIdAudite(Long idAudite) {
		this.idAudite = idAudite;
	}

	public Long getNumPlanning() {
		return numPlanning;
	}

	public void setNumPlanning(Long numPlanning) {
		this.numPlanning = numPlanning;
	}

	public Long getIdDepartement() {
		return idDepartement;
	}

	public void setIdDepartement(Long idDepartement) {
		this.idDepartement = idDepartement;
	}

	public User getAudite() {
		return audite;
	}

	public void setAudite(User audite) {
		this.audite = audite;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	
	

	
}
