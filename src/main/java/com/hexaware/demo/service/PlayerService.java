package com.hexaware.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hexaware.demo.entity.Player;

public interface PlayerService 
{
    Player addPlayer(Player player);
    List<Player> getAllPlayers();
    Player getPlayerById(int playerId);
    Player updatePlayer(int playerId,Player player);
    void deletePlayer(int playerId);
    
    
    
}
