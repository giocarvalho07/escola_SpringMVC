package com.escola.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escola.model.User;
import com.escola.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User getUserByLogin(String login, String pwd) {
		User user = userRepository.getUserByLogin(login);
		
		if(user != null) {
			if(!user.getPwd().equals(pwd)) {
				user = null;
			}
		}
		return user;
	}
}
