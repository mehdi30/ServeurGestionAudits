package com.example.demo.util;

public enum EtatPlanningEnum {
	

	EnCours ("En Cours"),
	Planifié ("Planifié"),
	Réalisé ("Réalisé");

	private String name;
	
	EtatPlanningEnum(String name){
		this.name = name ;
		}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
