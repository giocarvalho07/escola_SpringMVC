package com.escola.repository;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.escola.model.User;

@Repository
public class UserRepository {
	
	public HashMap<String, User> hashMap = new HashMap<String, User>();
	
	public UserRepository() {
		hashMap.put("admin", new User("admin", "Administrador do sistema", "admin123"));
	}
	
	public User getUserByLogin(String login) {
		return hashMap.get(login);
		}

}
