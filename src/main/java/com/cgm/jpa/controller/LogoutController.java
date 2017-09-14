package com.cgm.jpa.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	@ResponseBody
	protected ModelAndView getLogout(HttpServletRequest request) {
		request.getSession().removeAttribute("username");
		return new ModelAndView("redirect:/");
	}
	
}
