package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.example.demo.util.EfficaciteEnum;
import com.example.demo.util.RessourceEnum;
import com.example.demo.util.StatusEnum;
import com.example.demo.util.TypeActionEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ActionProjet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 1024)
	private String cause;

	private LocalDateTime dateLancement;

	@ManyToOne
	private RapportProjet rapportProjet;

	@ManyToOne
	private Departement departement;

	@ManyToOne
	private Source source;

	@ManyToOne
	private EnJeux enJeux;

	@OnDelete(action = OnDeleteAction.CASCADE)
	@Column(name = "ecart_ID")
	private Integer ecartID;

	/*
	 * @OneToMany
	 * 
	 * @JoinColumn(name = "actionP_id", referencedColumnName = "id") private
	 * List<ActionProjet> autreActionProjets;
	 */

	@OneToMany
	@JoinColumn(name = "ACTIONPROJET_ID", referencedColumnName = "id")
	private List<SousAction> sousActions;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ActionProjet() {
		super();
	}

	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	public EnJeux getEnJeux() {
		return enJeux;
	}

	public void setEnJeux(EnJeux enJeux) {
		this.enJeux = enJeux;
	}

	public RapportProjet getRapportProjet() {
		return rapportProjet;
	}

	public void setRapportProjet(RapportProjet rapportProjet) {
		this.rapportProjet = rapportProjet;
	}

	public List<SousAction> getSousActions() {
		return sousActions;
	}

	public void setSousActions(List<SousAction> sousActions) {
		this.sousActions = sousActions;
	}

	public LocalDateTime getDateLancement() {
		return dateLancement;
	}

	public void setDateLancement(LocalDateTime dateLancement) {
		this.dateLancement = dateLancement;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public Integer getEcartID() {
		return ecartID;
	}

	public void setEcartID(Integer ecartID) {
		this.ecartID = ecartID;
	}

	
}
