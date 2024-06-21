package com.bobby.web.littlebobbyproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bobby.web.littlebobbyproject.dto.TeacherDto;
import com.bobby.web.littlebobbyproject.model.Teacher;
import com.bobby.web.littlebobbyproject.repository.TeacherRepository;

@Service
public class TeacherService {

	@Autowired
	private TeacherRepository teacherRepository;
	
	public List<Teacher> findAll() {
		return teacherRepository.findAll();
	}
	
	public Teacher save(TeacherDto teacherDto) {
		return teacherRepository.save(convertDtoToEntity(teacherDto));
	}
	
	public Teacher getElementById(Integer id) {
		return teacherRepository.getReferenceById(id);
	}
	
	private Teacher convertDtoToEntity(TeacherDto teacherDto) {
		Teacher teacher = new Teacher();
		teacher.setId(teacherDto.getId());
		teacher.setName(teacherDto.getName());
		teacher.setSurname(teacherDto.getSurname());
		teacher.setSalary(teacherDto.getSalary());
		teacher.setAge(teacherDto.getAge());
		teacher.setRating(teacherDto.getRating());
		teacher.setSubject(teacherDto.getSubject());
		
		return teacher;
	}

	public void remove(int id) {
		teacherRepository.deleteById(id);
		
	}
}
