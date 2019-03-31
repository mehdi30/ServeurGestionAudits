package com.example.demo.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Projet {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String title;
    
    // @JsonIgnore 
    //Pour éviter la boule infini lors de la serialisation vers JSON
    //Failed to write HTTP message: org.springframework.http.converter.HttpMessageNotWritableException: Could not write JSON: 
    //Infinite recursion (StackOverflowError)
     
    @OnDelete(action=OnDeleteAction.CASCADE)
	@ManyToOne
    private User manager;

	 @JsonIgnore 
	 @OneToMany(mappedBy="projet",cascade = CascadeType.ALL)
	 private List<PlanningProjet> planningProjets;
    

	public Projet(String title) {
		super();
		this.title = title;
	}


	public Projet() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public User getManager() {
		return manager;
	}


	public void setManager(User manager) {
		this.manager = manager;
	}


	

	
     
    
    
}
