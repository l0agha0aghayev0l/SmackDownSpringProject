package com.bobby.web.littlebobbyproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bobby.web.littlebobbyproject.model.User;
import com.bobby.web.littlebobbyproject.service.MainService;

@Controller
@RequestMapping("/main")
public class MainController {
	
	@Autowired
	MainService mainService;
	
	@GetMapping() // localhost:3030/alpha/main
	public String getMain(Model model) { 
		model.addAttribute("users", mainService.findAll());	
		return "main";
	}
	
	@GetMapping("/search") // localhost:3030/alpha/main/search?username=a
	public String getSearch(@RequestParam(name = "username") String username, Model model) {
		model.addAttribute("users", mainService.findByUsername(username));	
		return "main";
	}

	@GetMapping("/ayxan")
	public String getAyxan() {
		return "ayxan";
	}
	
	@GetMapping("/ziya")
	public String getZiya() {
		return "ziya";
	}
	
	@GetMapping("/sadi")
	public String getSadi() {
		return "sadi";
	}
	
	@GetMapping("/user/add")
	public String addUser(Model model) {
		User user = new User();	
		model.addAttribute("user", user);
		return "add_user";
	}
	
	@PostMapping("/user/save")
	public String saveUser(@ModelAttribute(name = "user") User user) {
		user.setId(mainService.findAll().size());
		mainService.add(user); 
		return "redirect:/main";
	}
	
	@GetMapping("/user/{id}") // localhost:3030/alpha/user/5
	public String getUser(@PathVariable(name = "id") Integer id, Model model) {
		if(mainService.getUserById(id) == null) {
			return "redirect:/main";
		}
		model.addAttribute("user", mainService.getUserById(id));
		return "user";
	}
}
