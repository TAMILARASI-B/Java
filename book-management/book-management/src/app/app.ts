import { Component } from '@angular/core';
import { RouterModule, RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common'; // ✅ Needed for *ngIf
import { Auth } from './auth';

@Component({
  selector: 'app-root',
  templateUrl: './app.html',
  standalone: true,
  imports: [RouterModule, RouterOutlet, CommonModule], // ✅ Add CommonModule here
  styleUrl: './app.css'
})
export class App {
  constructor(private authService: Auth) {}

  isLoggedIn(): boolean {
    return this.authService.isLoggedIn();
  }

  logout(): void {
    this.authService.logout();
  }
}
