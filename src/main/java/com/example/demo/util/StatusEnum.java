package com.example.demo.util;

public enum StatusEnum {
	
	EnCours ("En Cours"),
	Planifiée ("Planifiée"),
	Clôturée ("Clôturée"),
	Réalisée ("Réalisée"),
	EnAttente ("En Attente de validation"),
	Ouverte ("Ouverte");

	private String name;
	
	StatusEnum(String name){
		this.name = name ;
		}

	public String getName() {
		return name;
	}

}
