package com.cgm.jpa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cgm.jpa.db.repository.contract.UserDataStore;
import com.cgm.jpa.domain.ServiceResponse;
import com.cgm.jpa.domain.User;
import com.cgm.jpa.repository.UserDAO;


@RestController
public class UserController {

	@Autowired
	UserDAO userDAO;
	@Autowired
	UserDataStore userDataStore;

	public final static Logger logger = LoggerFactory
			.getLogger(UserController.class);

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody User getUser(@PathVariable Long id) throws Exception {
		logger.info("Called get User (" + id + ") service!");
		return userDAO.findById(id);
	}
/**/
	@RequestMapping(value = "/user", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ServiceResponse createUser(@RequestBody User user) {
		logger.info("Called create User JPA service!");
		userDAO.save(user);
		return new ServiceResponse();
	}
	
	@RequestMapping(value = "/user_db", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ServiceResponse createUserDB(@RequestBody User user) {
		logger.info("Called create user JDBC service!");
		userDataStore.storeUser(user);
		return new ServiceResponse();
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public ServiceResponse updateUser(@RequestBody User user, @PathVariable Long id) {
		logger.info("Called update user service!");
		// set id to make sure it can be merged in the persistence context
		user.setId(id);
		userDAO.update(user);
		return new ServiceResponse();
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ServiceResponse deleteUser(@PathVariable Long id) {
		logger.info("Called delete user (" + id + ")!");
		// remove uses find by id to make sure the specified entity is present in the persistence context
		userDAO.delete(id);
		return new ServiceResponse();
	}
/**/
	
}
