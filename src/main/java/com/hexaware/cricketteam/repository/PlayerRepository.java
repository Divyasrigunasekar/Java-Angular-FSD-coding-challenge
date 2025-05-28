package com.hexaware.cricketteam.repository;

import com.hexaware.cricketteam.entity.Player;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
	List<Player> findByRole(String role);
}
