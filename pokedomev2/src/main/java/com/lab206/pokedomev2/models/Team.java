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
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="teams")
public class Team {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    private int teamWins;
    
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name="user_id")
    private User user;
    
    @ManyToMany (fetch = FetchType.LAZY) 
    @JoinTable (
    		name = "team_members",
    		joinColumns = @JoinColumn (name = "team_id"),
    		inverseJoinColumns = @JoinColumn (name = "pokemon_id")
    )
    private List<Pokemon> pokemons;
    
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    public Team () {
    	
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Pokemon> getPokemons() {
		return pokemons;
	}
	public void setPokemons(List<Pokemon> pokemons) {
		this.pokemons = pokemons;
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
	
	public int getTeamWins() {
		return teamWins;
	}
	public void setTeamWins(int teamWins) {
		this.teamWins = teamWins;
	}
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
