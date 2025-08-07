import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { BookService } from '../services/bookservice';

@Component({
  selector: 'app-book-list',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './book-list.html',
  styleUrls: ['./book-list.css']
})
export class BookList implements OnInit {
  books: any[] = [];

  constructor(private bookService: BookService) {}

  ngOnInit(): void {
    this.loadBooks();
  }

  loadBooks(): void {
    this.bookService.getBooks().subscribe({
      next: (data: any[]) => this.books = data,
      error: err => alert("Failed to load books.")
    });
  }

  deleteBook(isbn: number): void {
    if (confirm('Are you sure you want to delete this book?')) {
      this.bookService.deleteBook(isbn).subscribe({
        next: () => {
          alert('Book deleted successfully.');
          this.loadBooks(); // reload
        },
        error: () => alert('Failed to delete book.')
      });
    }
  }
}
