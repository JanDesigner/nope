package com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.domain.Post;

public interface PostRepository extends JpaRepository<Post,Integer> {
	
	List<Post> findTop10ByUsersIdOrderByIdDesc(Long id);
	
	
}
