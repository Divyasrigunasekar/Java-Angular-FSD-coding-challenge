import { Component, OnInit } from '@angular/core';
import { Player } from 'src/app/models/player.model';
import { PlayerService } from 'src/app/services/player.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-player-list',
  templateUrl: './player-list.component.html',
  styleUrls: ['./player-list.component.css']
})
export class PlayerListComponent implements OnInit {

  players: Player[] = [];
  searchId: number = 0;

  constructor(
    private playerService: PlayerService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadPlayers();
  }

  loadPlayers(): void {
    this.playerService.getAllPlayers().subscribe({
      next: (data) => {
        this.players = data;
      },
      error: (err) => {
        console.error('Error fetching players', err);
      }
    });
  }

  deletePlayer(id: number): void {
    if (confirm('Are you sure you want to delete this player?')) {
      this.playerService.deletePlayer(id).subscribe({
        next: () => {
  alert('Player deleted successfully');
  this.loadPlayers();
},
error: (err) => {
  alert('Failed to delete player. Please try again.');
  console.error('Error deleting player', err);
}
      });
    }
  }

  updatePlayer(id: number): void {
    this.router.navigate(['/update-player', id]);
  }

  addPlayer(): void {
    this.router.navigate(['/add-player']);
  }
  searchById(): void {
  if (!this.searchId) {
    this.loadPlayers();
    return;
  }
  this.playerService.getPlayerById(this.searchId).subscribe({
    next: (player) => this.players = [player],
    error: () => {
      alert('Player not found');
      this.players = [];
    }
  });
}
}



