package com.lab206.pokedomev2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lab206.pokedomev2.services.UserService;

@Controller
public class ProfileController {

	private UserService userService;
	
	public ProfileController (UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping ("/profile")
	public String profile() {
		return "views/profile.jsp";
	}
}
