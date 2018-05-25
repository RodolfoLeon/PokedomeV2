package com.lab206.pokedomev2.services;

import org.springframework.stereotype.Service;

import com.lab206.pokedomev2.repositories.PokemonRepository;
import com.lab206.pokedomev2.repositories.TeamRepository;

@Service
public class TeamService {

	TeamRepository teamRepo;
	PokemonRepository pokeRepo;
	
	public TeamService (TeamRepository teamRepo, PokemonRepository poke) {
		this.teamRepo = teamRepo;
		this.pokeRepo = poke;
	}
	
//	public void addPokemon (Long teamId, Long pokeId) {
//		Pokemon pokemon = pokeRepo.findById(pokeId).get();
//		Team team = teamRepo.findById(teamId);
//		
//		teamRepo.save(
//		List<Pokemon> list = 
//		
//	}
}
