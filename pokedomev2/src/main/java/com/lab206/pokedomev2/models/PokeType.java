package com.lab206.pokedomev2.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="poketypes")
public class PokeType {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    @ManyToMany (fetch = FetchType.LAZY) 		
	@JoinTable (
    		name = "pokemon_types",
    		joinColumns = @JoinColumn (name = "poketype_id"),
    		inverseJoinColumns = @JoinColumn (name = "pokemon_id")
    )
    private List<Pokemon> pokemons;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Pokemon> getPokemons() {
		return pokemons;
	}

	public void setPokemons(List<Pokemon> pokemons) {
		this.pokemons = pokemons;
	}
    
    
    
}
