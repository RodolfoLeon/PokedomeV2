package com.lab206.pokedomev2.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab206.pokedomev2.models.Pokemon;
import com.lab206.pokedomev2.services.PokemonService;


@RestController
public class PokedomeController {
	
	PokemonService pokeService;
	
	public PokedomeController (PokemonService pokeService) {
		this.pokeService = pokeService;
	}
	
//	@RequestMapping (path="/profile", produces="text/html;charset=UTF-8")
//	@ResponseBody
//	public String profile() {
//		System.out.println("It is getting here");
//		return "tags/trainerProfile.tag";
//	}
	
	@RequestMapping("/pokemon/get/{id}")
	public Pokemon getPokemon (@PathVariable ("id") Long id) {
		Pokemon pokemon = pokeService.getPokemon(id);
		return new Pokemon (pokemon);
	}
	
//	@RequestMapping ("/pokemon/get/{id}")
//	public User getUserWins ()
	
	
//	@RequestMapping ("/fight")
//	public String fight() {
//		System.out.println("It is getting here");
//		return "they are fighting";
//	}
	
}
