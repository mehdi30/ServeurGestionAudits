package com.example.demo.util;

public enum TypeEnJeuxEnum {

	Interne("Interne"), Externe("Externe");

	private String name;

	TypeEnJeuxEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
