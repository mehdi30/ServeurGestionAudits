package com.example.demo.util;

public enum EfficaciteEnum {
	
	Efficace ("Efficace"),
	Moyennement ("Moyennement Efficace"),
	NonEfficace ("Non Efficace");
	

	private String name;
	
	EfficaciteEnum(String name){
		this.name = name ;
		}

	public String getName() {
		return name;
	}

}
