package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class PlanningDepartPk implements Serializable{

	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long idAudit;
	
	private Long idAuditeur;
	
	private Long idAudite;

	
	private Long numPlanning;

	private Long idDepartement;

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

	public Long getIdDepartement() {
		return idDepartement;
	}

	public void setIdDepartement(Long idDepartement) {
		this.idDepartement = idDepartement;
	}

	public Long getIdAudite() {
		return idAudite;
	}

	public void setIdAudite(Long idAudite) {
		this.idAudite = idAudite;
	}
	
	
}
