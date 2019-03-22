package com.example.demo.entity;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Projet {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String title;
    
    
    // @JsonIgnore 
    //Pour éviter la boule infini lors de la serialisation vers JSON
    //Failed to write HTTP message: org.springframework.http.converter.HttpMessageNotWritableException: Could not write JSON: 
    //Infinite recursion (StackOverflowError)
    @JsonIgnore 
    @ManyToOne
    private User manager;

    

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
