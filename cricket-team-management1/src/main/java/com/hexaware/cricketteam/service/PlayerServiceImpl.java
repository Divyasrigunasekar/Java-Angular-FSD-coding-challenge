package com.hexaware.cricketteam.service;

import com.hexaware.cricketteam.dto.PlayerListDTO;
import com.hexaware.cricketteam.entity.Player;
import com.hexaware.cricketteam.exceptions.PlayerNotFoundException;
import com.hexaware.cricketteam.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements IPlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Player getPlayerById(Long playerId) {
        Optional<Player> optionalPlayer = playerRepository.findById(playerId);
        return optionalPlayer.orElseThrow(() -> new PlayerNotFoundException("Player not found with ID: " + playerId));
    }

    @Override
    public List<Player> getAllPlayers() {
        List<Player> players = playerRepository.findAll();
        if (players.isEmpty()) {
            throw new PlayerNotFoundException("No players found");
        }
        return players;
    }

    @Override
    public Player updatePlayer(Long playerId, Player updatedPlayer) {
        Player existingPlayer = getPlayerById(playerId);

        existingPlayer.setPlayerName(updatedPlayer.getPlayerName());
        existingPlayer.setJerseyNumber(updatedPlayer.getJerseyNumber());
        existingPlayer.setRole(updatedPlayer.getRole());
        existingPlayer.setTotalMatches(updatedPlayer.getTotalMatches());
        existingPlayer.setTeamName(updatedPlayer.getTeamName());
        existingPlayer.setState(updatedPlayer.getState());
        existingPlayer.setDescription(updatedPlayer.getDescription());

        return playerRepository.save(existingPlayer);
    }

    @Override
    public void deletePlayer(Long playerId) {
        Player existingPlayer = getPlayerById(playerId);
        playerRepository.delete(existingPlayer);
    }

    @Override
    public List<PlayerListDTO> getAllPlayerList() {
        List<Player> players = playerRepository.findAll();
        if (players.isEmpty()) {
            throw new PlayerNotFoundException("No players found");
        }
        List<PlayerListDTO> listDTO = new ArrayList<>();
        for (Player p : players) {
            listDTO.add(new PlayerListDTO(
                p.getPlayerId(),
                p.getPlayerName(),
                p.getJerseyNumber(),
                p.getRole()
            ));
        }
        return listDTO;
    }
//	Getting Player By Role
	  @Override public List<Player> getPlayersByRole(String role) { List<Player>
	  players = playerRepository.findByRole(role); if (players.isEmpty()) { throw
	  new PlayerNotFoundException("No players found with role: " + role); } return
	  players; }
	 
}
