package com.bobby.web.littlebobbyproject.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class User {

	private int id;
	private String username;
	private String name;
	private String surname;
	private int age;
	private String country;

	public User() {
	}

	public User(int id, String username, String name, String surname, int age, String country) {
		super();
		this.id = id;
		this.username = username;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.country = country;
	}
	
}
