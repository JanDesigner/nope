package com.springboot.Service;

import com.springboot.domain.LikePost;
import com.springboot.domain.Post;
import com.springboot.domain.User;

public interface LikePostService {
 public void findAndSave(LikePost likePost, User user, Post post);

 
}
