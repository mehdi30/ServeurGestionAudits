package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Embeddable
public class PlanningProjetPk implements Serializable{

	private Long numPlanning;

	private Long idAudit;
	
	private Long idAuditeur;
	

	//private Long idProjet;

	public void setIdAuditeur(Long idAuditeur) {
		this.idAuditeur = idAuditeur;
	}

	public Long getNumPlanning() {
		return numPlanning;
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

	

	public void setNumPlanning(Long numPlanning) {
		this.numPlanning = numPlanning;
	}

	/*public Long getIdProjet() {
		return idProjet;
	}

	public void setIdProjet(Long idProjet) {
		this.idProjet = idProjet;
	}*/



	

	
	
	
}
