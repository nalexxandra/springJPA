package com.cgm.jpa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cgm.jpa.domain.Message;
import com.cgm.jpa.services.MessageService;


@RestController
@RequestMapping("/messages")
public class MessageController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView messages() {
		return new ModelAndView("messages");
	}
	
	@Autowired
	MessageService messageService;
	
	@RequestMapping(value = "/getMessages", method = RequestMethod.GET)
	public @ResponseBody Map<String,List<Message>> getMessages(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String username = (String) request.getSession().getAttribute("username");
		List<Message> messages = null;
		if (username != null) {
			messages = messageService.getMessages(username);
		}
		Map<String,List<Message>> userMessages = new HashMap<String, List<Message>>();
		userMessages.put(username, messages);
		return userMessages;
	}

	@RequestMapping(value = "/addMessage", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Message addMessage(@RequestBody Message message, HttpServletRequest request) throws Exception {
		String username = (String)request.getSession().getAttribute("username");
		messageService.postMessage(message, username);
		return message;
	}
	
}
