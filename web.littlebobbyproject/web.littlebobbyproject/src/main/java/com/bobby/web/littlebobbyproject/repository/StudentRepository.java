package com.bobby.web.littlebobbyproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bobby.web.littlebobbyproject.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	List<Student> findAllByName(String name);

}
