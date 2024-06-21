package com.bobby.web.littlebobbyproject.dto;

import java.time.LocalDate;
import java.util.Date;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
	
	private Integer id;
	
	@NotNull(message = "Please, input your name")
	@NotEmpty(message = "Please, input your name")
	private String name;

	@NotNull(message = "Please, input your surname")
	@NotEmpty(message = "Please, input your surname")
	private String surname;
	
	@Past(message = "Error")
	@NotNull(message = "Please, input your birthday")
	private LocalDate birthday;
	
	@NotNull(message = "Please, input your address")
	@NotEmpty(message = "Please, input your address")
	private String address;
	
	@NotNull(message = "Please, input your age")
	@Min(value = 1, message = "You must take number between from 1 to 12")
	@Max(value = 12, message = "You must take number between from 1 to 12")
	private int grade;
	
	@NotNull(message = "Please, input your school")
	@NotEmpty(message = "Please, input your school")
	private String school;
	
	private String description;
}
