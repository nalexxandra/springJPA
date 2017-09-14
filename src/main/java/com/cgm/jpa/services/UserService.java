package com.cgm.jpa.services;

import java.util.List;
import com.cgm.jpa.domain.User;

public interface UserService {

	public User getAccount(User account);
	public User findUser(Long id);
	
	public List<User> getFriends(String username);
	public List<User> getUsers(String username);
}
