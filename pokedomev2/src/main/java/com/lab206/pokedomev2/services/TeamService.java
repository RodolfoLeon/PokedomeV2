package com.lab206.pokedomev2.services;

import org.springframework.stereotype.Service;

import com.lab206.pokedomev2.repositories.TeamRepository;

@Service
public class TeamService {

	TeamRepository teamRepo;
	
	public TeamService (TeamRepository teamRepo) {
		this.teamRepo = teamRepo;
	}
}
