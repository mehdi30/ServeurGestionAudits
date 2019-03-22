package com.example.demo.util;

public enum ProcessusEnum {
	
	Technique ("Technique"),
	Commerciale ("Commerciale"),
	RH ("RH"),
	Administrative ("Administrative"),
	Dévelopement ("Dévelopement");
	
	private  String name;
	
	ProcessusEnum(String name){
		this.name = name ;
		}

	public String getName() {
		return name;
	}
	

	
}
