package com.lab206.pokedomev2.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lab206.pokedomev2.models.Pokemon;
import com.lab206.pokedomev2.repositories.PokemonRepository;

@Service
public class PokemonService {
	
	private PokemonRepository pokeRepo;
	
	public PokemonService (PokemonRepository pokeRepo) {
		this.pokeRepo = pokeRepo;
	}
	
	public List<Pokemon> allPokemon() {
		return pokeRepo.findAll();
	}
	
	public Pokemon getPokemon(Long id) {
		return pokeRepo.findById(id).get();
	}
}
