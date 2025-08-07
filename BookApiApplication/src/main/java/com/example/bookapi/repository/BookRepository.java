package com.example.bookapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookapi.entity.Book;

public interface BookRepository extends JpaRepository<Book, String> {
}

