package com.springboot.Service;

import java.util.List;

import com.springboot.domain.User;

public interface UserService {

	
	User findByEmail(String email);
	void findAndSaved(User user);
	User findByRolesRole(String role);
	
	
}
