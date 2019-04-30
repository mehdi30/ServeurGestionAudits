package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.demo.util.EfficaciteEnum;
import com.example.demo.util.TypeEnJeuxEnum;

@Entity
public class EnJeux {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	private String nom;
	
	@Column(length = 1024)
    private String description;
	
	@Enumerated(EnumType.STRING)
    private TypeEnJeuxEnum typeEnJeux;

	public EnJeux() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TypeEnJeuxEnum getTypeEnJeux() {
		return typeEnJeux;
	}

	public void setTypeEnJeux(TypeEnJeuxEnum typeEnJeux) {
		this.typeEnJeux = typeEnJeux;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	
}
