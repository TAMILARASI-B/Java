import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, ReactiveFormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { Auth } from '../auth';
import { tap } from 'rxjs/operators';

@Component({
  selector: 'app-login',
  standalone: true,
  templateUrl: './login.html',
  styleUrls: ['./login.css'],
  imports: [CommonModule, ReactiveFormsModule, RouterLink]
})
export class Login implements OnInit {
  loginForm!: FormGroup;

  constructor(private auth: Auth, private router: Router) {}

  ngOnInit() {
    this.loginForm = new FormGroup({
      email: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', Validators.required)
    });
  }

 onSubmit() {
  if (this.loginForm.invalid) {
    return; // No alert needed
  }

  this.auth.login(this.loginForm.value).subscribe({
    next: () => {
      this.router.navigate(['/books']); // ✅ Redirect directly
    },
    error: () => {
      alert('Login failed! Check email or password.');
    }
  });
}

}
