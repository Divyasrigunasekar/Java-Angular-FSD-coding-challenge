import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PlayerListComponent } from './components/player-list/player-list.component';
import { PlayerAddComponent } from './components/player-add/player-add.component';
import { PlayerUpdateComponent } from './components/player-update/player-update.component';
import { HomeComponent } from './components/home/home.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'players', component: PlayerListComponent },
  { path: 'add-player', component: PlayerAddComponent },
  { path: 'update-player/:id', component: PlayerUpdateComponent }
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
