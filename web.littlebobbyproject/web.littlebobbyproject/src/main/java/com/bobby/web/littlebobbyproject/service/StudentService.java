package com.bobby.web.littlebobbyproject.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.catalina.valves.StuckThreadDetectionValve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bobby.web.littlebobbyproject.dto.StudentDto;
import com.bobby.web.littlebobbyproject.model.Student;
import com.bobby.web.littlebobbyproject.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> findAll() { 
		return studentRepository.findAll();
	}
	
	public void save(StudentDto studentDto) {
		Student student = studentDtoToStudent(studentDto);
		studentRepository.save(student); // insert || update
	}
	
	public Student getElementById(int id) {
		return studentRepository.getReferenceById(id);
	}
	
	public void remove(int id) {
		studentRepository.deleteById(id);
	}
	
	private Student studentDtoToStudent(StudentDto studentDto) {
		Student student = new Student();
		student.setId(studentDto.getId());
		student.setName(studentDto.getName());
		student.setSurname(studentDto.getSurname());
		student.setBirthday(studentDto.getBirthday());
		student.setAddress(studentDto.getAddress());
		student.setSchool(studentDto.getSchool());
		student.setGrade(studentDto.getGrade());
		student.setDescription(studentDto.getDescription());
		return student;
	}

	public List<Student> findByName(String name) {
		System.out.println(studentRepository.findAllByName(name));
		return studentRepository.findAllByName(name);
	}
}
