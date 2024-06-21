package com.bobby.web.littlebobbyproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bobby.web.littlebobbyproject.dto.StudentDto;
import com.bobby.web.littlebobbyproject.dto.TeacherDto;
import com.bobby.web.littlebobbyproject.model.Student;
import com.bobby.web.littlebobbyproject.model.User;
import com.bobby.web.littlebobbyproject.repository.TeacherRepository;
import com.bobby.web.littlebobbyproject.service.StudentService;
import com.bobby.web.littlebobbyproject.service.TeacherService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/school")
public class SchoolController {

	@Autowired
	StudentService studentService;
	
	@Autowired
	TeacherService teacherService;

	@GetMapping("/students") // localhost:3030/school/main
	public String getStudentMainPage(Model model) {
		StudentDto student = new StudentDto();
		model.addAttribute("student", student);
		model.addAttribute("students", studentService.findAll());
		return "student_main";
	}

	@PostMapping("/student/save") // localhost:3030/school/student/save
	public String saveStudent(@Valid @ModelAttribute("student") StudentDto student, BindingResult result) {
		if (result.hasErrors()) {
			return "student_main";
		}
		studentService.save(student);
		return "redirect:/school/students";
	}
	
	@GetMapping("/students/search")
	public String searchStudent(@RequestParam(value = "name") String name, Model model) {
		StudentDto student = new StudentDto();
		model.addAttribute("student", student);
		System.out.println("Work");
		model.addAttribute("students", studentService.findByName(name));
		return "student_main";
	}

	@GetMapping("/student/{id}") // localhost:3030/student/3
	public String getMoreAboutStudent(@PathVariable(name = "id") int id, Model model) {
		model.addAttribute("student", studentService.getElementById(id));
		return "student";
	}

	@GetMapping("/student/remove/{id}")
	public String removeStudent(@PathVariable(name = "id") int id) {
		studentService.remove(id);
		return "redirect:/school/students";
	}

	@GetMapping("/teachers")
	public String getTeacherMainPage(Model model) {
		TeacherDto teacherDto = new TeacherDto();
		model.addAttribute("teacher", teacherDto);
		model.addAttribute("teachers", teacherService.findAll());
		return "teacher_main";
	}
	
	@PostMapping("/teacher/save") // localhost:3030/school/student/save
	public String saveTeacher(@Valid @ModelAttribute("teacher") TeacherDto teacher, BindingResult result) {
		if (result.hasErrors()) {
			return "student_main";
		}
		teacherService.save(teacher);
		return "redirect:/school/teachers";
	}
	
	@GetMapping("/teacher/{id}") // localhost:3030/student/3
	public String getMoreAboutTeacher(@PathVariable(name = "id") int id, Model model) {
		model.addAttribute("teacher", teacherService.getElementById(id));
		return "teacher";
	}
	
	@GetMapping("/teacher/remove/{id}")
	public String removeTeacher(@PathVariable(name = "id") int id) {
		teacherService.remove(id);
		return "redirect:/school/teachers";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		StringTrimmerEditor trimmer = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, trimmer);
	}
	
	
	

}
