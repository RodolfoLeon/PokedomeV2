package com.lab206.pokedomev2.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lab206.pokedomev2.models.Pokemon;

@Repository
public interface PokemonRepository extends CrudRepository<Pokemon, Long>{
	List<Pokemon> findAll();
}
