package com.springboot.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.domain.DoLong;
import com.springboot.domain.Message;
import com.springboot.domain.User;
import com.springboot.repository.MessageRepository;
import com.springboot.repository.UserRepository;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {

	@Autowired
	MessageRepository messageRepository;
	@Autowired
	UserRepository userRepository;
	
	
	@Override
	public void findAndSaveMessage(Message message , User user) {
		
		user.getMyMessage().add(message);
		
		User userx= userRepository.findByEmail(user.getEmail());
		long senderId = user.getId();
		long receiverEmail = userx.getId();
		DoLong doLong = new DoLong(senderId,receiverEmail);
		user.setMyInbox(new HashSet<DoLong> (Arrays.asList(doLong) ) );
		
		messageRepository.save(message);
		
	}

}
