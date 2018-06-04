package com.springboot.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.domain.Post;
import com.springboot.domain.User;
import com.springboot.repository.LikePostRepository;
import com.springboot.repository.PostRepository;
import com.springboot.repository.RoleRepository;
import com.springboot.repository.UserRepository;

@Service
@Transactional
public class PostServiceImpl implements PostService{
	
	@Autowired
	PostRepository postRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired 
	UserRepository userRepository;
	
	@Autowired
	LikePostRepository likePostRepository;
	
	@Override
	public List<Post> findByUsersId(Long id) {
	
		 List<Post> post= postRepository.findTop10ByUsersIdOrderByIdDesc(id);
		return post;
	}

	@Override
	public List<Post> findAll() {

		return (List<Post>) postRepository.findAll();
	}

	@Override
	public void findAndSave(Post post , User user) {
		
		post.setUsers(user);
		postRepository.save(post);
		
		
	}

	@Override
	public Post findById(int id) {
		return postRepository.findById(id).get();
	}




	
	
	
}
