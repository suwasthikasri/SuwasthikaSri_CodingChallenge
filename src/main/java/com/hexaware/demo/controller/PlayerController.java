package com.hexaware.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.hexaware.demo.entity.Player;
import com.hexaware.demo.service.PlayerService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/players")
public class PlayerController 
{
  @Autowired
  PlayerService service;
  

  @GetMapping
  public List<Player> getAllPlayers(){
      return service.getAllPlayers();
  }

  @PostMapping
  public Player addPlayer(@Valid @RequestBody Player player){
      return service.addPlayer(player);
  }

  @GetMapping("/{playerId}")
  public Player getPlayerById(@PathVariable int playerId){
      return service.getPlayerById(playerId);
  }

  @PutMapping("/{playerId}")
  public Player updatePlayer(@PathVariable int playerId,
                             @Valid @RequestBody Player player){
      return service.updatePlayer(playerId, player);
  }

  @DeleteMapping("/{playerId}")
  public String deletePlayer(@PathVariable int playerId){
      service.deletePlayer(playerId);
      return "Player deleted successfully";
  }
  
}
