package com.lab206.pokedomev2.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="pokemons")
public class Pokemon {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

	private String name;
	private String description;
		
	private Double pk_height;
	
	private Double pk_weight;
	
	@ManyToMany (fetch = FetchType.LAZY) 		
	@JoinTable (
    		name = "team_members",
    		joinColumns = @JoinColumn (name = "pokemon_id"),
    		inverseJoinColumns = @JoinColumn (name = "team_id")
    )
    private List<Team> teams;
	
	
	@ManyToMany (fetch = FetchType.LAZY) 		
	@JoinTable (
    		name = "pokemon_types",
    		joinColumns = @JoinColumn (name = "pokemon_id"),
    		inverseJoinColumns = @JoinColumn (name = "poketype_id")
    )
    private List<PokeType> types;
	
	
    @Column(updatable=false)
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date createdAt;
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date updatedAt;
    
    public Pokemon () {
    	
    }
    
    public Pokemon (Pokemon pokemon) {
    	this.id = pokemon.getId();
    	this.name = pokemon.getName();
    	this.description = pokemon.getDescription();
    	this.pk_height = pokemon.getPk_height();
    	this.pk_weight = pokemon.getPk_weight();
    }
    
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
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPk_height() {
		return pk_height;
	}
	public void setPk_height(Double pk_height) {
		this.pk_height = pk_height;
	}
	public List<Team> getTeams() {
		return teams;
	}
	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	public Double getPk_weight() {
		return pk_weight;
	}
	public void setPk_weight(Double pk_weight) {
		this.pk_weight = pk_weight;
	}

	public List<PokeType> getTypes() {
		return types;
	}

	public void setTypes(List<PokeType> types) {
		this.types = types;
	}
	 
    
}
