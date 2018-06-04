package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	public Role findByRole(String role);
	
}
