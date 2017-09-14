package com.cgm.jpa.repository;

import org.springframework.stereotype.Repository;

import com.cgm.jpa.domain.User;

@Repository
public class UserDAO extends AbstractDAO<User> {

	protected UserDAO() {
		super(User.class);
	}
	
}
