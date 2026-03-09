package com.hexaware.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.demo.entity.Player;
import com.hexaware.demo.exception.ResourceNotFoundException;
import com.hexaware.demo.repo.PlayerRepository;
@Service
public class PlayerServiceImpl implements PlayerService
{
      @Autowired
      PlayerRepository repo;
      
	@Override
	public Player addPlayer(Player player) {
		
		return repo.save(player);
	}

	@Override
	public List<Player> getAllPlayers() {
		
		return repo.findAll();
	}

	@Override
	public Player getPlayerById(int playerId) {
		return repo.findById(playerId).orElseThrow(()-> new ResourceNotFoundException("Player not found with id"));
	}

	

	@Override
	public Player updatePlayer(int playerId, Player player) {
		Player existing =repo.findById(playerId).orElseThrow(()->new ResourceNotFoundException("Player not found with id"));
		existing.setPlayerName(player.getPlayerName());
        existing.setJerseyNumber(player.getJerseyNumber());
        existing.setRole(player.getRole());
        existing.setTotalMatches(player.getTotalMatches());
        existing.setTeamName(player.getTeamName());
        existing.setCountryOrState(player.getCountryOrState());
        existing.setDescription(player.getDescription());
        
        return repo.save(existing); 
	}

	@Override
	public void deletePlayer(int playerId) {
     
		Player player=repo.findById(playerId).orElseThrow(()-> new ResourceNotFoundException("Player not found with id"));
		repo.delete(player);
		System.out.println("Player deleted with id "+ playerId);

	}

}
