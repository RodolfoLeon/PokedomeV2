package com.lab206.pokedomev2.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lab206.pokedomev2.models.Pokemon;
import com.lab206.pokedomev2.models.Team;
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
	
	public void addPokemon (Long teamId, Long pokeId) {
		Pokemon pokemon = pokeRepo.findById(pokeId).get();
		Team team = teamRepo.findById(teamId).get();
		List<Pokemon> list = team.getPokemons();
		list.add(pokemon);
		team.setPokemons(list);
		teamRepo.save(team);
	}
}
