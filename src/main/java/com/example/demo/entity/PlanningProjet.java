package com.example.demo.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long numPlanning;

	private Long idProjet;


	private Long idDepartement;

	private LocalDateTime datePlan;

	private boolean etat = false;

	@Column(length = 1024)
	private String description;

	@Enumerated(EnumType.STRING)
	private TypePlanningEnum typePlanning;
	
    @OnDelete(action=OnDeleteAction.CASCADE)
	@ManyToMany
	@JoinTable(name="PLANS_AUDITEURS",
	joinColumns={@JoinColumn(name="PLANS_ID")},
	inverseJoinColumns={@JoinColumn(name="AUDITEUR_ID")})
	private List<User> auditeurs;
	
    @OnDelete(action=OnDeleteAction.CASCADE)
	@ManyToMany
	@JoinTable(name="PLANS_AUDITES",
	joinColumns={@JoinColumn(name="PLANS_ID")},
	inverseJoinColumns={@JoinColumn(name="AUDITE_ID")})
	private List<User> audites;
	
    @OnDelete(action=OnDeleteAction.CASCADE)
	@ManyToOne// insertable=false,updatable=false c'est pas la responsabilite planning// projet// d'ajouter ou màj l'auditeur
	@JoinColumn(name = "idProjet", referencedColumnName = "id", insertable = false, updatable = false)
	private Projet projet;
    
    @OnDelete(action=OnDeleteAction.CASCADE)
	@ManyToOne
	@JoinColumn(name = "idDepartement", referencedColumnName = "idDep", insertable = false, updatable = false)
	private Departement departement;

	public PlanningProjet() {
		super();
	}

	public PlanningProjet(Audit audit) {
		super();

	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public Long getNumPlanning() {
		return numPlanning;
	}

	public void setNumPlanning(Long numPlanning) {
		this.numPlanning = numPlanning;
	}


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
	
	public List<User> getAuditeurs() {
		return auditeurs;
	}

	public void setAuditeurs(List<User> auditeurs) {
		this.auditeurs = auditeurs;
	}

	public List<User> getAudites() {
		return audites;
	}

	public void setAudites(List<User> audites) {
		this.audites = audites;
	}
	
	


}
