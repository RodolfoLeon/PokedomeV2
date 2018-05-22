package com.lab206.pokedomev2.controllers;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lab206.pokedomev2.models.User;
import com.lab206.pokedomev2.services.UserService;
import com.lab206.pokedomev2.validator.UserValidator;

@Controller
public class UserControllers {
	
	private final UserService userService;
	private final UserValidator userValidator;
	public UserControllers(UserService userService, UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;
	}
	
	@RequestMapping("/login")
    public String login_reg(@ModelAttribute("new_user") User user, @RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model m) {
        if (error != null) {
        	m.addAttribute("error", "Invalid Email/Password Combination");
        } else if (logout != null) {
        	m.addAttribute("logout", "Logged out successfully!");
        }
		return "index.jsp";
    }
	
	@PostMapping("/registration")
	public String register(@Valid @ModelAttribute("new_user") User user, BindingResult result, Model model, HttpSession session) {
		System.out.println("here");
		userValidator.validate(user, result);
		if (result.hasErrors()) {
			return "index.jsp";
		}else {
			userService.saveWithUserRole(user);
	        return "redirect:/login";
		}
	}
	
	@RequestMapping(value = {"/events"})
    public String home(Principal principal, Model model) {
        String username = principal.getName();
        User u = userService.findByUsername(username);
        model.addAttribute("currentUser", u);
        return "dashboard.jsp";
    }
}
