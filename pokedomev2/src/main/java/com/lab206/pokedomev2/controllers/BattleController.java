package com.lab206.pokedomev2.controllers;

import java.security.Principal;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lab206.pokedomev2.models.User;
import com.lab206.pokedomev2.services.UserService;

@Controller
public class BattleController {

	private UserService userService;
	
	public BattleController (UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping ("/battle")
	public String battle(Model model, Principal principal) {
		
		List<User> allUsers = userService.getAllUsers();
		Random random = new Random();
		User user = userService.findByUsername(principal.getName());		
		User oponent = allUsers.get(random.nextInt(allUsers.size()));
		
		while (oponent == user) {
			oponent = allUsers.get(random.nextInt(allUsers.size()));
		}
		
		model.addAttribute("user", user);
		model.addAttribute("oponent", oponent);
		
		return "views/battle.jsp";
	}
}
