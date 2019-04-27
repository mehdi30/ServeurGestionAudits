package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Embeddable
public class PlanningProjetPk implements Serializable {

	private Long numPlanning;

	public Long getNumPlanning() {
		return numPlanning;
	}

	public void setNumPlanning(Long numPlanning) {
		this.numPlanning = numPlanning;
	}

	/*
	 * public Long getIdProjet() { return idProjet; }
	 * 
	 * public void setIdProjet(Long idProjet) { this.idProjet = idProjet; }
	 */

}
