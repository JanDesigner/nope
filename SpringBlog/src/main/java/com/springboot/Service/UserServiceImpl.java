package com.springboot.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.domain.Role;
import com.springboot.domain.User;
import com.springboot.repository.RoleRepository;
import com.springboot.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	@Override
	public User findByEmail(String email) {
		
		User user = userRepository.findByEmail(email);
		return user;
	}


	@Override
	public void findAndSaved(User user) {
	
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setEnabled(1);
		Role role = roleRepository.findByRole("MEMBER");
		user.setRoles(new HashSet<Role> (Arrays.asList(role)));
		userRepository.save(user);
		
	}


	@Override
	public User findByRolesRole(String role) {
		
		return userRepository.findByRolesRole(role);
	}




	
	

}
