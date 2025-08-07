import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { Auth } from '../auth';

@Component({
  selector: 'app-register',
  standalone: true,
  templateUrl: './register.html',
  styleUrls: ['./register.css'],
  imports: [CommonModule, ReactiveFormsModule, RouterLink]
})
export class Register {
  registerForm: FormGroup;

  constructor(private fb: FormBuilder, private auth: Auth, private router: Router) {
    this.registerForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required],
      role: ['USER']
    });
  }

  onSubmit() {
    if (this.registerForm.invalid) {
      alert('Please fill out all fields correctly.');
      return;
    }

    this.auth.register(this.registerForm.value).subscribe({
      next: () => {
        alert('Registration successful!');
        this.router.navigate(['/login']);
      },
      error: () => alert('Registration failed! Please try again.')
    });
  }
}
