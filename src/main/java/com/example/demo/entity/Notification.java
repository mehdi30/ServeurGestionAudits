package com.example.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Notification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 1024)
	private String title;
	
	private String type;
	
	private LocalDateTime dateNot;

	private boolean nSeen = false ;

	@ManyToOne
	private User user;

	public Notification() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDateTime getDateNot() {
		return dateNot;
	}

	public void setDateNot(LocalDateTime dateNot) {
		this.dateNot = dateNot;
	}

	public boolean isnSeen() {
		return nSeen;
	}

	public void setnSeen(boolean nSeen) {
		this.nSeen = nSeen;
	}

	
	
	
	
}
