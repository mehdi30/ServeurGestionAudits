package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)      //@Column(name="USER_ID")
	private Long id;
	
	@Column(unique=true)
	private String username;
	
	private String password;
	
	private boolean enable;
	
    @JsonIgnore 
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="USERS_ROLES",
	joinColumns={@JoinColumn(name="USER_ID")},
	inverseJoinColumns={@JoinColumn(name="ROLE_ID")})
	private List<Role> roles;

    @JsonIgnore 
    @ManyToOne(fetch=FetchType.EAGER)
    private Departement departement;
    
    @JsonIgnore 
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "manager")
    private List<Projet> projets;  
	
    @JsonIgnore 
	@OneToMany(mappedBy="auditeur",cascade = CascadeType.ALL)
    private List<PlanningProjet> planningProjets;
    
    @JsonIgnore 
	@OneToMany(mappedBy="auditeur",cascade = CascadeType.ALL)
    private List<PlanningDepart> planningDepartAuditeur;

    @JsonIgnore 
	@OneToMany(mappedBy="audite",cascade = CascadeType.ALL)
    private List<PlanningDepart> planningDepartAudite;
    
	public List<PlanningProjet> getPlanningProjets() {
		return planningProjets;
	}

	public void setPlanningProjets(List<PlanningProjet> planningProjets) {
		this.planningProjets = planningProjets;
	}

	public User(String username, String password, boolean enable) {
		super();
		this.username = username;
		this.password = password;
		this.enable = enable;
	}

	public User() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Projet> getProjets() {
		return projets;
	}

	public void setProjets(List<Projet> projets) {
		this.projets = projets;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public List<PlanningDepart> getPlanningDepartAuditeur() {
		return planningDepartAuditeur;
	}

	public void setPlanningDepartAuditeur(List<PlanningDepart> planningDepartAuditeur) {
		this.planningDepartAuditeur = planningDepartAuditeur;
	}

	public List<PlanningDepart> getPlanningDepartAudite() {
		return planningDepartAudite;
	}

	public void setPlanningDepartAudite(List<PlanningDepart> planningDepartAudite) {
		this.planningDepartAudite = planningDepartAudite;
	}

	
	
	
}