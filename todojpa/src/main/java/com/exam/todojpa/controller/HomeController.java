package com.exam.todojpa.controller;

import java.security.Principal;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exam.todojpa.domain.User;
import com.exam.todojpa.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(Locale locale, Model model) {
	public String home(Principal principal) {
		logger.info("principal {}.", principal);

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		logger.info("auth.getName() = " + auth.getName());
		
		if(principal != null) {
			User user = userService.getUser(principal.getName());
			logger.info("user = " + user);
		}
		
		return "home";
	}
	
}
