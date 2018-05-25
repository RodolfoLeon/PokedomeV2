package com.lab206.pokedomev2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lab206.pokedomev2.services.PokemonService;

@Controller
public class PokedexController {
	
	PokemonService pokeServ;
	
	public PokedexController(PokemonService pokeServ){
		this.pokeServ = pokeServ;
	}
	
	@RequestMapping ("/pokedex")
	public String pokedex (Model m) {
		m.addAttribute("allPokemons", pokeServ.allPokemon() );
		m.addAttribute("pokemon", pokeServ.getPokemon((long) 1) );
		return "views/pokedex.jsp";
	}

	@RequestMapping ("/pokedex/{id}")
	public String pokeInfo (@PathVariable("id") Long id, Model m) {
		m.addAttribute("allPokemons", pokeServ.allPokemon() );
		m.addAttribute("pokemon", pokeServ.getPokemon(id) );
		return "views/pokedex.jsp";
	}
	
}
