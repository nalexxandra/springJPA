package com.cgm.jpa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cgm.jpa.domain.User;
import com.cgm.jpa.repository.UserDAO;
import com.cgm.jpa.services.UserService;


@RestController
@RequestMapping("friends")
public class FriendsController {

	@Autowired
	UserService userService;
	@Autowired
	UserDAO userDAO;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView Users(ModelMap model) {
		return new ModelAndView("friends");
	}

	@RequestMapping(value="/getFriends" ,method = RequestMethod.GET)
	public @ResponseBody Map<String,List<User>> getFriends(HttpServletRequest request){
		String user = (String) request.getSession().getAttribute("username");
		List<User> friends = userService.getFriends(user);
		
		Map<String,List<User>> userFriends = new HashMap<String, List<User>>();
		userFriends.put(user, friends);
		
		
		return userFriends;
	}

	@RequestMapping(value="/getUsers", method = RequestMethod.GET)
	public List<User> getUsers(HttpServletRequest request){
		List<User> users = userDAO.findAll();
		return users;
	}
}

