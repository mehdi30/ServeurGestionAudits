package com.example.demo.util;

public enum TypeProjetEnum {

	TMA("TMA"), FORFAITAIRE("Forfaitaire");

	private String name;

	TypeProjetEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
