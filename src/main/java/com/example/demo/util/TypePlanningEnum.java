package com.example.demo.util;

public enum TypePlanningEnum {

	Interne("Interne"), Externe("Externe");

	private String name;

	TypePlanningEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
