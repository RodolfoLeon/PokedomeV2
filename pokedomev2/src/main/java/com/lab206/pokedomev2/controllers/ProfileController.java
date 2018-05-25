package com.lab206.pokedomev2.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lab206.pokedomev2.models.User;
import com.lab206.pokedomev2.services.TeamService;
import com.lab206.pokedomev2.services.UserService;

@Controller
public class ProfileController {

	private UserService userService;
	private TeamService teamService;
	
	
	public ProfileController (UserService userService, TeamService teamService) {
		this.userService = userService;
		this.teamService = teamService;
	}
	
	@RequestMapping ("/profile")
	public String profile(Principal principal, Model model) {
		User user = userService.findByUsername( principal.getName() );
		model.addAttribute("user", user);
		return "views/profile.jsp";
	}
	
	@PostMapping ("/profile")
	public String removePokemonFromTeam(@RequestParam("team_id") Long teamId, @RequestParam("poke_id") Long pokeId, Principal principal, Model model) {
		teamService.removePokemon(teamId, pokeId);
		return "redirect:/profile";
	}
	@PostMapping ("/profile/newTeam")
	public String createTeam(@RequestParam("team_name") String name, Principal principal, Model model) {
		User user = userService.findByUsername( principal.getName() );
		teamService.newTeam(user, name);
		return "redirect:/profile";
	}
	@PostMapping ("/profile/deleteTeam")
	public String destroyTeam(@RequestParam("team_id") Long teamId, Principal principal, Model model) {
		teamService.deleteTeam(teamId);
		return "redirect:/profile";
	}
	
	
}
