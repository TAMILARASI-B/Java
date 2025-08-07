package com.example.bookapi.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.bookapi.entity.Book;
import com.example.bookapi.exception.ResourceNotFoundException;
import com.example.bookapi.repository.BookRepository;
import com.example.bookapi.service.BookService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepo;

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public Book getBookByIsbn(String isbn) {
        return bookRepo.findById(isbn)
            .orElseThrow(() -> new ResourceNotFoundException("Book not found with ISBN: " + isbn));
    }


    public Book addBook(Book book) {
        return bookRepo.save(book);
    }

    public Book updateBook(Book book) {
        return bookRepo.save(book);
    }

    public void deleteBook(String isbn) {
        bookRepo.deleteById(isbn);
    }
}
