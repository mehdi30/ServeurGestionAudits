package com.example.demo.util;

public enum RessourceEnum {

	Humaines ("Humaines"),
	Matérielles ("Matérielles"),
	Financières ("Financières");

	private String name;
	
	RessourceEnum(String name){
		this.name = name ;
		}

	public String getName() {
		return name;
	}

}
