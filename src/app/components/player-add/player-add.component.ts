import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { PlayerService } from 'src/app/services/player.service';
import { Player } from 'src/app/models/player.model';

@Component({
  selector: 'app-player-add',
  templateUrl: './player-add.component.html',
  styleUrls: ['./player-add.component.css']
})
export class PlayerAddComponent {
  player: Player = {
    playerId: 0,
    playerName: '',
    jerseyNumber: 0,
    role: '',
    totalMatches: 0,
    teamName: '',
    state: '',
    description: ''
  };

  constructor(private playerService: PlayerService, private router: Router) {}

  onSubmit(): void {
    this.playerService.addPlayer(this.player).subscribe(() => {
      alert('Player added successfully');
      this.router.navigate(['/']);
    });
  }
}
