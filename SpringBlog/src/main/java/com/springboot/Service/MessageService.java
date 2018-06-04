package com.springboot.Service;

import com.springboot.domain.Message;
import com.springboot.domain.User;

public interface MessageService {
	
	
	void findAndSaveMessage(Message message, User user);
	
	
}
