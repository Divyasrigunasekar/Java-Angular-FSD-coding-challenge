import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PlayerService } from 'src/app/services/player.service';
import { Player } from 'src/app/models/player.model';

@Component({
  selector: 'app-player-update',
  templateUrl: './player-update.component.html',
  styleUrls: ['./player-update.component.css']
})
export class PlayerUpdateComponent implements OnInit {
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

  constructor(
    private route: ActivatedRoute,
    private playerService: PlayerService,
    public router: Router
  ) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.playerService.getPlayerById(id).subscribe({
      next: (data) => this.player = data,
      error: () => alert('Player not found')
    });
  }

  onSubmit(): void {
  if (!this.player.playerId || this.player.playerId <= 0) {
    alert('Invalid player ID. Cannot update player.');
    return;
  }

  this.playerService.updatePlayer(this.player.playerId, this.player).subscribe(() => {
    alert('Player updated successfully');
    this.router.navigate(['/']);
  }, error => {
    alert('Error updating player. Please try again.');
  });
}
}
