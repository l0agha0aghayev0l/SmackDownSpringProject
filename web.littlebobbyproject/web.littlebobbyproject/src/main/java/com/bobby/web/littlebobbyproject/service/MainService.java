package com.bobby.web.littlebobbyproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bobby.web.littlebobbyproject.model.User;

@Service
public class MainService {
	
	private List<User> users = new ArrayList<>();
	
	{
		users.add(new User(1, "ziya", "Ziya", "Ismayilov", 13, "AZ"));
		users.add(new User(2, "riyad", "Riyad", "Tagiyev", 15, "AZ"));
		users.add(new User(3, "azizaga", "Azizaga", "Quliyev", 13, "AZ"));
		users.add(new User(4, "murshlack", "Murad", "Ismayilzade", 13, "AZ"));
		users.add(new User(5, "bobby", "Eldar", "Mamedov", 14, "AZ"));
		users.add(new User(6, "ayxanchik", "Ayxan", "Qadirli", 16, "AZ"));
		users.add(new User(7, "ceyhun", "Ceyhun", "Huseynzade", 15, "AZ"));
		users.add(new User(8, "agadadash", "Sadi", "Dashdemirli", 13, "AZ"));
	}
	
	public List<User> findAll() {
		return users;
	}
	
	public List<User> findByUsername(String username) {
		List<User> selectedUsers = new ArrayList<>();
		
		for (User u : findAll()) {
			if (u.getUsername().contains(username)) {
				selectedUsers.add(u);
			}
		}
		return selectedUsers;
	}
	
	public void add(User user) {
		users.add(user);
	}
	
	public User getUserById(int id) {
		for (User u : findAll()) {
			if (u.getId() == id) {
				return u;
			}
		}
		return null;
	}
	

}
