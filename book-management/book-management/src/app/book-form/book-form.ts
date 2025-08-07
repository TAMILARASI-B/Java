import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, ReactiveFormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { BookService } from '../services/bookservice';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-book-form',
  standalone: true,
  templateUrl: './book-form.html',
  styleUrls: ['./book-form.css'],
  imports: [CommonModule, ReactiveFormsModule, RouterLink, HttpClientModule]
})
export class BookForm implements OnInit {
  bookForm!: FormGroup;
  isEdit: boolean = false;
  currentId!: number;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private bookService: BookService
  ) {}

  ngOnInit() {
    this.bookForm = new FormGroup({
      isbn: new FormControl('', Validators.required),
      title: new FormControl('', Validators.required),
      author: new FormControl('', Validators.required),
      publicationYear: new FormControl('', [
        Validators.required,
        Validators.pattern('^[0-9]{4}$')
      ])
    });

    // Check if we are in edit mode
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.isEdit = true;
      this.currentId = +id;

      this.bookService.getBookById(this.currentId).subscribe({
        next: (book) => {
          this.bookForm.patchValue(book);
        },
        error: () => {
          alert('Failed to load book data');
        }
      });
    }
  }

  onSubmit() {
    if (this.bookForm.invalid) {
      alert('Please fill all fields');
      return;
    }

    if (this.isEdit) {
      this.bookService.updateBook(this.currentId, this.bookForm.value).subscribe({
        next: () => {
          alert('Book updated successfully!');
          this.router.navigate(['/books']);
        },
        error: () => alert('Failed to update book')
      });
    } else {
      this.bookService.addBook(this.bookForm.value).subscribe({
        next: () => {
          alert('Book added successfully!');
          this.router.navigate(['/books']);
        },
        error: () => alert('Failed to add book')
      });
    }
  }
}
