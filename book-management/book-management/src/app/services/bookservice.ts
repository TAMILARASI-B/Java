import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  private baseUrl = 'http://localhost:9998/api/books';

  constructor(private http: HttpClient) {}

  private getAuthHeaders(): HttpHeaders {
    const token = localStorage.getItem('token');
    return new HttpHeaders({
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json'
    });
  }

  getBooks(): Observable<any[]> {
    return this.http.get<any[]>(this.baseUrl, {
      headers: this.getAuthHeaders()
    });
  }

  getBookById(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`, {
      headers: this.getAuthHeaders()
    });
  }

  addBook(book: any): Observable<any> {
    return this.http.post(this.baseUrl, book, {
      headers: this.getAuthHeaders(),
      responseType: 'text'
    });
  }

  updateBook(id: number, book: any): Observable<any> {
    return this.http.put(`${this.baseUrl}/${id}`, book, {
      headers: this.getAuthHeaders()
    });
  }

  deleteBook(isbn: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${isbn}`, {
      headers: this.getAuthHeaders()
    });
  }
}
