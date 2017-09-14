package com.cgm.jpa.repository;

import org.springframework.stereotype.Repository;
import com.cgm.jpa.domain.Message;

@Repository
public class MessageDAO extends AbstractDAO<Message> {

	protected MessageDAO() {
		super(Message.class);
	}
}