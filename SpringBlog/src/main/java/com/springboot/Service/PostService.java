package com.springboot.Service;

import java.util.List;

import com.springboot.domain.Post;
import com.springboot.domain.User;

public interface PostService {
	List<Post> findByUsersId(Long id);
	List<Post> findAll();
	void findAndSave(Post post, User user);
	Post findById(int id);
	
}
