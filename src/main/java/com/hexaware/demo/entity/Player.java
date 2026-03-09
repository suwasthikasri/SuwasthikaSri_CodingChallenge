package com.hexaware.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;

@Entity
@Table(name="players")
public class Player
{  
	@Id
    private int playerId;
	
	@NotBlank(message="Player name is required")
	private String playerName;
	
	@Min(value=1,message="Jersey number must be greater than 0")
	private int jerseyNumber;
	
	@NotBlank(message="Role is required")
	private String role;
	
	@Min(value=0,message="Total matches should be >=0")
	private int totalMatches;
	
	@NotBlank(message="Team name is required")
    private String teamName;

	
	@NotBlank(message="Country or State name is required")
	private String countryOrState;
	
	private String description;
	
	public Player() {}
	
	

	public Player(int playerId, @NotBlank(message = "Player name is required") String playerName,
			@Min(value = 1, message = "Jersey number must be greater than 0") int jerseyNumber,
			@NotBlank(message = "Role is required") String role,
			@Min(value = 0, message = "Total matches should be >=0") int totalMatches,
			@NotBlank(message = "Team name is required") String teamName,
			@NotBlank(message = "Country or State name is required") String countryOrState, String description) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.jerseyNumber = jerseyNumber;
		this.role = role;
		this.totalMatches = totalMatches;
		this.teamName = teamName;
		this.countryOrState = countryOrState;
		this.description = description;
	}



	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getJerseyNumber() {
		return jerseyNumber;
	}

	public void setJerseyNumber(int jerseyNumber) {
		this.jerseyNumber = jerseyNumber;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getTotalMatches() {
		return totalMatches;
	}

	public void setTotalMatches(int totalMatches) {
		this.totalMatches = totalMatches;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getCountryOrState() {
		return countryOrState;
	}

	public void setCountryOrState(String countryOrState) {
		this.countryOrState = countryOrState;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", playerName=" + playerName + ", jerseyNumber=" + jerseyNumber
				+ ", role=" + role + ", totalMatches=" + totalMatches + ", teamName=" + teamName + ", countryOrState="
				+ countryOrState + ", description=" + description + "]";
	}
	
	

	
	
	
	
	
	
}
