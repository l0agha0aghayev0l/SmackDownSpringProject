package com.bobby.web.littlebobbyproject.dto;

import lombok.Data;

@Data
public class TeacherDto {
	
	private Integer id;
	private String name;
	private String surname;
	private int age;
	private String subject;
	private double rating;
	private int salary;
}
