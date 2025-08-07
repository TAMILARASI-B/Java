import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class Auth implements CanActivate {

  constructor(private http: HttpClient, private router: Router) {}

  register(user: any) {
    return this.http.post('http://localhost:9998/register', user, {
      responseType: 'text' // Backend returns plain text
    });
  }

  login(credentials: any) {
    return this.http.post('http://localhost:9998/login', credentials, {
      responseType: 'text'
    }).pipe(
      tap(token => {
        localStorage.setItem('token', token); // ✅ Store using 'token'
      })
    );
  }

  canActivate(): boolean {
    const isLoggedIn = !!localStorage.getItem('token'); // ✅ use 'token'
    if (!isLoggedIn) {
      this.router.navigate(['/login']);
      return false;
    }
    return true;
  }

  logout() {
    localStorage.removeItem('token'); // ✅ consistent key
    this.router.navigate(['/login']);
  }

  isLoggedIn() {
    return !!localStorage.getItem('token');
  }

  getToken() {
    return localStorage.getItem('token');
  }
}
