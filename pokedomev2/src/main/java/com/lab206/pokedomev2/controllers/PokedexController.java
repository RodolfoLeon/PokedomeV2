package com.lab206.pokedomev2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PokedexController {
	
	@RequestMapping ("/pokedex")
	public String pokedex () {
		return "views/pokedex.jsp";
	}
}
