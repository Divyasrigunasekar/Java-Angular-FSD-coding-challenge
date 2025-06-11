package com.hexaware.cricketteam.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @NotNull(message = "Player ID is required to add Player")
    @Min(value = 1, message="PlayerID shouldn't be Zero")
    private Long playerId;

    @NotBlank(message = "Player name must not be blank")
    @Size(max = 100, message = "Player name must be at most 100 characters")
    private String playerName;

    @NotNull(message = "Jersey number is required")
    @Min(value = 0, message = "Jersey number must be non-negative")
    private Integer jerseyNumber;

    @NotBlank(message = "Role must not be blank")
    @Pattern(regexp = "Batter|Bowler|All Rounder|Keeper", 
    message = "Role must be one of: Batter, Bowler, All Rounder, Keeper")
    private String role;

    @NotNull(message = "Total matches is required")
    @Min(value = 0, message = "Total matches must be 0 or more")
    private Integer totalMatches;

    @NotBlank(message = "Team name must not be blank")
    private String teamName;

    @NotBlank(message = "State must not be blank")
    private String state;

    @Size(max = 300, message = "Description can be up to 300 characters")
    private String description;

    // Getters and Setters

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
                ", state='" + state + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}