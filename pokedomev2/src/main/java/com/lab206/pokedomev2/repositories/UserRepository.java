package com.lab206.pokedomev2.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lab206.pokedomev2.models.User;

@Repository
public interface UserRepository extends CrudRepository <User, Long>{

	User findByUsername(String name);
	List<User> findAll();

}
