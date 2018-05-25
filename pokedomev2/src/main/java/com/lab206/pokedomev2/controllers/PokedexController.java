package com.lab206.pokedomev2.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lab206.pokedomev2.services.PokemonService;
import com.lab206.pokedomev2.services.TeamService;
import com.lab206.pokedomev2.services.UserService;

@Controller
public class PokedexController {
	
	PokemonService pokeServ;
	UserService userServ;
	TeamService teamServ;
	
	
	public PokedexController(PokemonService pokeServ, UserService userServ, TeamService teamServ){
		this.pokeServ = pokeServ;
		this.userServ = userServ;
		this.teamServ = teamServ;
		
	}
	
	@RequestMapping ("/pokedex")
	public String pokedex (Model m, Principal p) {
		m.addAttribute("user", userServ.findByUsername(p.getName()));
		m.addAttribute("allPokemons", pokeServ.allPokemon() );
		m.addAttribute("currentPokemon", pokeServ.getPokemon((long) 1) );
		return "views/pokedex.jsp";
	}

	@RequestMapping ("/pokedex/{id}")
	public String pokeInfo (@PathVariable("id") Long id, Model m, Principal p) {
		m.addAttribute("user", userServ.findByUsername(p.getName()));
		m.addAttribute("allPokemons", pokeServ.allPokemon() );
		m.addAttribute("currentPokemon", pokeServ.getPokemon(id) );
		return "views/pokedex.jsp";
	}
	@PostMapping ("/pokedex/{id}")
	public String addPokemonToTeam (@RequestParam("team_id") Long team_id,@PathVariable("id") Long id, Model m, Principal p) {
		if (team_id == 0) {
			return ("redirect:/pokedex/"+id);
		} else {
			teamServ.addPokemon(team_id, id);
			m.addAttribute("allPokemons", pokeServ.allPokemon() );
			m.addAttribute("currentPokemon", pokeServ.getPokemon(id) );
			return "views/pokedex.jsp";
		}
	}
}
