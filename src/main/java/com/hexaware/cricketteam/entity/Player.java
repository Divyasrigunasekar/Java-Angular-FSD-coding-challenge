package com.hexaware.cricketteam.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "players")
public class Player {

    @Id
    private Long playerId;

    private String playerName;

    private Integer jerseyNumber;

    private String role;

    private Integer totalMatches;

    private String teamName;

    private String state;

    private String description;


    public Long getPlayerId() {
        return playerId;
    }
    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }
    public String getPlayerName() {
        return playerName;
    }
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    public Integer getJerseyNumber() {
        return jerseyNumber;
    }
    public void setJerseyNumber(Integer jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public Integer getTotalMatches() {
        return totalMatches;
    }
    public void setTotalMatches(Integer totalMatches) {
        this.totalMatches = totalMatches;
    }
    public String getTeamName() {
        return teamName;
    }
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    public String getState() {
        return state;
    }
    public void setState(String countryState) {
        this.state = countryState;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerId=" + playerId +
                ", playerName='" + playerName + '\'' +
                ", jerseyNumber=" + jerseyNumber +
                ", role='" + role + '\'' +
                ", totalMatches=" + totalMatches +
                ", teamName='" + teamName + '\'' +
                ", State='" + state + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
