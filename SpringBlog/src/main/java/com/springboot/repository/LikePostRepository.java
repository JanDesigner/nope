package com.springboot.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.domain.LikePost;

public interface LikePostRepository extends JpaRepository<LikePost,Integer>{
	
	
	int countById(int id);
	
	
	int countLikePostByPostsId(Integer id);
	
}
