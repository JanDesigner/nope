package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
