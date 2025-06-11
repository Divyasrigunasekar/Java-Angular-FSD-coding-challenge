import { Component, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  @Output() toggleListEvent = new EventEmitter<void>();

  togglePlayerList() {
    this.toggleListEvent.emit(); // Emit event to parent (AppComponent)
  }
}