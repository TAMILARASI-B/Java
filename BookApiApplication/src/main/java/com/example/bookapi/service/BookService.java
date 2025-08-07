package com.example.bookapi.service;

import java.util.List;

import com.example.bookapi.entity.Book;

public interface BookService {
    List<Book> getAllBooks();
    Book getBookByIsbn(String isbn);
    Book addBook(Book book);
    Book updateBook(Book book);
    void deleteBook(String isbn);
}
