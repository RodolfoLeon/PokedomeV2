package com.lab206.pokedomev2.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lab206.pokedomev2.models.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{

	List<Role> findByName(String string);

}
