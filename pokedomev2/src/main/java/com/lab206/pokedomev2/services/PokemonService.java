package com.lab206.pokedomev2.services;

import org.springframework.stereotype.Service;

import com.lab206.pokedomev2.repositories.PokemonRepository;

@Service
public class PokemonService {
	
	private PokemonRepository pokeRepo;
	
	public PokemonService (PokemonRepository pokeRepo) {
		this.pokeRepo = pokeRepo;
	}
}
