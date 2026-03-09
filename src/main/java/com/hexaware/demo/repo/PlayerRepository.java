package com.hexaware.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.demo.entity.Player;

public interface PlayerRepository  extends JpaRepository<Player, Integer>
{

}
