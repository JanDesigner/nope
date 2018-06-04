package com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.domain.User;

public interface UserRepository extends JpaRepository<User,Long>{
	
	public User findByEmail(String email);
	User findByRolesRole(String role);
	
	

}