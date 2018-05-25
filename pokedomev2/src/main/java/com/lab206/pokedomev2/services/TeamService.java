package com.lab206.pokedomev2.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lab206.pokedomev2.models.Pokemon;
import com.lab206.pokedomev2.models.Team;
import com.lab206.pokedomev2.models.User;
import com.lab206.pokedomev2.repositories.PokemonRepository;
import com.lab206.pokedomev2.repositories.TeamRepository;
import com.lab206.pokedomev2.repositories.UserRepository;

@Service
public class TeamService {

	TeamRepository teamRepo;
	PokemonRepository pokeRepo;
	UserRepository userRepo;
	
	public TeamService (TeamRepository teamRepo, PokemonRepository pokeRepo, UserRepository userRepo) {
		this.teamRepo = teamRepo;
		this.pokeRepo = pokeRepo;
		this.userRepo = userRepo;
	}
	
	public void addPokemon (Long teamId, Long pokeId) {
		Pokemon pokemon = pokeRepo.findById(pokeId).get();
		Team team = teamRepo.findById(teamId).get();
		List<Pokemon> list = team.getPokemons();
		if (list.size() < 3) {
			list.add(pokemon);			
		}
		team.setPokemons(list);
		teamRepo.save(team);
	}
	public void removePokemon (Long teamId, Long pokeId) {
		Pokemon pokemon = pokeRepo.findById(pokeId).get();
		Team team = teamRepo.findById(teamId).get();
		List<Pokemon> list = team.getPokemons();
		list.remove(pokemon);
		team.setPokemons(list);
		teamRepo.save(team);
	}
	
	public void newTeam(User user, String name) {
		Team new_team = new Team();
		new_team.setUser(user);
		new_team.setName(name);
		new_team.setId((Long) (teamRepo.count() + 1));
		teamRepo.save(new_team);
	}
	public void deleteTeam(Long teamId) {
		teamRepo.deleteById(teamId);
	}

	public Team getTeam(Long teamId) {
		return teamRepo.findById(teamId).get();
	}
}
