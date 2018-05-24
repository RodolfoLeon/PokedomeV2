package com.lab206.pokedomev2.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lab206.pokedomev2.models.Team;

@Repository
public interface TeamRepository  extends CrudRepository<Team, Long> {
	List<Team> findAll();
}
