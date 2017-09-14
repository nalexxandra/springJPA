package com.cgm.jpa.services;

import java.util.List;
import com.cgm.jpa.domain.Message;

public interface MessageService {

	void postMessage(Message message, String username);
	public List<Message> getMessages(String username);
	
	
}
