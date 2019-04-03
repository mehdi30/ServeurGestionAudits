package com.example.demo.util;

public enum TypeActionEnum {
	
	Préventive ("Préventive"),
	Curative ("Curative/Correction"),
	Corrective ("Corrective");

	private String name;
	
	TypeActionEnum(String name){
		this.name = name ;
		}

	public String getName() {
		return name;
	}

}
