package com.hexaware.cricketteam.controller;

import com.hexaware.cricketteam.dto.PlayerListDTO;
import com.hexaware.cricketteam.entity.Player;
import com.hexaware.cricketteam.exceptions.PlayerNotFoundException;
import com.hexaware.cricketteam.service.IPlayerService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200") 
@RestController
@RequestMapping("/api/players")
public class PlayerController {

	@Autowired
	private IPlayerService playerService;

	// Add a player
	@PostMapping
	public ResponseEntity<Player> addPlayer(@Valid @RequestBody Player player) {
		Player savedPlayer = playerService.addPlayer(player);
		return ResponseEntity.ok(savedPlayer);
	}

	// Get player by ID
	@GetMapping("/{id}")
	public ResponseEntity<Player> getPlayerById(@PathVariable("id") Long id) {
		Player player = playerService.getPlayerById(id);
		return ResponseEntity.ok(player);
	}

	// Get all players (full entity)
	@GetMapping
	public ResponseEntity<List<Player>> getAllPlayers() {
		List<Player> players = playerService.getAllPlayers();
		return ResponseEntity.ok(players);
	}

	// Get all players but only selected fields (PlayerListDTO)
	@GetMapping("/summary")
	public ResponseEntity<List<PlayerListDTO>> getAllPlayerList() {
		List<PlayerListDTO> playerList = playerService.getAllPlayerList();
		return ResponseEntity.ok(playerList);
	}

	// Update player
	@PutMapping("/{id}")
	public ResponseEntity<Player> updatePlayer(@PathVariable("id") Long id,@Valid @RequestBody Player player) {
		Player updatedPlayer = playerService.updatePlayer(id, player);
		return ResponseEntity.ok(updatedPlayer);
	}

	// Delete player
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePlayer(@PathVariable("id") Long id) {
		playerService.deletePlayer(id);
		return ResponseEntity.noContent().build();
	}

	// Exception handler for PlayerNotFoundException
	@ExceptionHandler(PlayerNotFoundException.class)
	public ResponseEntity<String> handlePlayerNotFound(PlayerNotFoundException ex) {
		return ResponseEntity.status(404).body(ex.getMessage());
	}

	//	Getting Player By Role
	
	  @GetMapping("/role/{role}") public ResponseEntity<List<Player>>
	  getPlayersByRole(@PathVariable String role) { List<Player> players =
	  playerService.getPlayersByRole(role); return new ResponseEntity<>(players,
	  HttpStatus.OK); }
	 
	 
}
