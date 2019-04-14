package com.example.demo.util;

public enum EfficaciteEnum {
	
	Efficace ("Efficace"),
	Moyennement ("Moyennement Efficace"),
	NonEfficace ("Non Efficace"),
	Vide ("Vide");

	private String name;
	
	EfficaciteEnum(String name){
		this.name = name ;
		}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
