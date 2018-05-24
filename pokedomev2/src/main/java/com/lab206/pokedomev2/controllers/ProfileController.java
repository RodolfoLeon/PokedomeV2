package com.lab206.pokedomev2.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lab206.pokedomev2.models.Team;
import com.lab206.pokedomev2.models.User;
import com.lab206.pokedomev2.services.UserService;

@Controller
public class ProfileController {

	private UserService userService;
	
	public ProfileController (UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping ("/profile")
	public String profile(Principal principal, Model model) {
		
		User user = userService.findByUsername( principal.getName() );
		List <Team> teamList = user.getTeams();
		for (Team team : teamList) {
			System.out.println(team);
		}
		model.addAttribute("user", user);
		return "views/profile.jsp";
	}
}
