package com.hexaware.cricketteam.service;

import com.hexaware.cricketteam.dto.PlayerListDTO;
import com.hexaware.cricketteam.entity.Player;
import java.util.List;

public interface IPlayerService {

    Player addPlayer(Player player);

    Player getPlayerById(Long playerId);

    List<Player> getAllPlayers();

    Player updatePlayer(Long playerId, Player updatedPlayer);

    void deletePlayer(Long playerId);
    
    List<PlayerListDTO> getAllPlayerList();
//	Getting Player By Role
    List<Player> getPlayersByRole(String role);
}