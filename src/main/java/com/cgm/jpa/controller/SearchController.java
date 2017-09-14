package com.cgm.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cgm.jpa.domain.ServiceResponse;
import com.cgm.jpa.domain.User;
import com.cgm.jpa.repository.AbstractDAO;

@RestController
@RequestMapping("/search")
public class SearchController {
	
	@Autowired
	@Qualifier("userDAO")
	AbstractDAO<User> userDAO;
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	 @ResponseBody
	 public ServiceResponse findUser(@RequestBody String username) {
	  ServiceResponse response = new ServiceResponse();
	  response.setCode(200);
	  User user = userDAO.findByUsername(username.substring(1, username.length() - 1));
	  if(user.getUsername() != "") {
		  response.setMessage("User found!");
	  } else {
		  response.setCode(202);
		  response.setMessage("User not found!");
	  }
	  return response;
	 }
}
