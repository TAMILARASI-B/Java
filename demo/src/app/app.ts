import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.html',
  standalone: false,
  styleUrl: './app.css'
})
export class App {
 constructor(public router: Router) {}

  isLoginPage(): boolean {
    return this.router.url === '/login' || this.router.url === '/signup';
}
}
