package com.springboot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.domain.LikePost;
import com.springboot.domain.Post;
import com.springboot.domain.User;
import com.springboot.repository.LikePostRepository;
import com.springboot.repository.PostRepository;

@Service
@Transactional
public class LikePostServiceImpl implements LikePostService  {

	@Autowired
	LikePostRepository likePostRepository;
	@Autowired 
	PostRepository postRepositry;
	
	@Override
	public void findAndSave(LikePost likePost , User user , Post post) {
		
		likePost.setPosts(post);
		likePost.setUserId(user.getId());
		
		//always true 
		likePost.setPostState(1);
		
		
		likePostRepository.save(likePost);
		
		int count = likePostRepository.countLikePostByPostsId(post.getId());
		post.setCountLikes(count);
	}



}
