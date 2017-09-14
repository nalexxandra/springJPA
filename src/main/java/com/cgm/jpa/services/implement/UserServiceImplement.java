package com.cgm.jpa.services.implement;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cgm.jpa.domain.User;
import com.cgm.jpa.repository.AbstractDAO;
import com.cgm.jpa.services.UserService;

@Service
public class UserServiceImplement implements UserService {

	@Autowired
	@Qualifier("userDAO")
	AbstractDAO<User> userDAO;

	@Override
	public User getAccount(User account) {
		User user=null;
		try {
			user = userDAO.findByUsername(account.getUsername());
			if(user.getPassword().equals(account.getPassword())) {
				return user;
			}else {
				return null;
			}
		} catch (NoResultException ex) {
			return user;
		}
	}


	@Override
	public User findUser(Long id) {
		return userDAO.findById(id);
	}
	
	@Override
	public List<User> getFriends(String username) {
		User user = userDAO.findByUsername(username);
		List<User> friends = user.getUser();
		
		return friends;
	}
	
	@Override
	public List<User> getUsers(String username){
		User user = userDAO.findByUsername(username);
		List<User> friends = user.getUser();
		List<User> users = userDAO.findAllUsers(username);
		for(User friend : friends) {
			for(User duplicateUser:users) {
				if(friend.getUsername().equals(duplicateUser.getUsername())) {
					users.remove(duplicateUser);
				}
			}
		}
		return users;
	}
	

	
	
}
