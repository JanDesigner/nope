package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.domain.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {

}
