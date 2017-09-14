package com.cgm.jpa.services.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cgm.jpa.domain.Message;
import com.cgm.jpa.domain.User;
import com.cgm.jpa.repository.AbstractDAO;
import com.cgm.jpa.services.MessageService;

@Service
public class MessageServiceImplement implements MessageService {

	@Autowired
	@Qualifier("userDAO")
	AbstractDAO<User> userDAO;
	
	@Autowired
	@Qualifier("messageDAO")
	AbstractDAO<Message> messageDAO;
	
	@Override
	public void postMessage(Message message, String username) {
		User user = userDAO.findByUsername(username);
		message.setUser(user);
		messageDAO.update(message);
	}
	
	@Override 
	public List<Message> getMessages(String username){
		User user = userDAO.findByUsername(username);
		List<Message> messages = messageDAO.findAllMessages(user);
		messages = user.getMessages();
		return messages;
	}
	
}
