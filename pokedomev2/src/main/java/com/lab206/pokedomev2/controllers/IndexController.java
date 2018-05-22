package com.lab206.pokedomev2.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lab206.pokedomev2.models.User;

@Controller
public class IndexController {

	@RequestMapping ("/")
	public String index (@ModelAttribute ("user") User user) {
		return "views/index.jsp";
	}
}
