package com.example.demo.util;

public enum TypeConstatEnum {

	PointFort ("Point Fort"),
	NC ("NC"),
	PP ("PP"),
	PS ("PS"),
	VIDE ("VIDE");

	private String name;
	
	TypeConstatEnum(String name){
		this.name = name ;
		}

	public String getName() {
		return name;
	}
}
