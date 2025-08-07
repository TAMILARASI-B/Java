package com.example.bookapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.bookapi.entity.Book;
import com.example.bookapi.repository.BookRepository;
import com.example.bookapi.serviceImpl.BookServiceImpl;

@SpringBootTest
public class BookServiceTest {
    @Mock
    private BookRepository repo;

    @InjectMocks
    private BookServiceImpl service;

    @Test
    void testGetAllBooks() {
        List<Book> books = List.of(new Book("123", "Title", "Author", 2020));
        when(repo.findAll()).thenReturn(books);
        assertEquals(1, service.getAllBooks().size());
    }
}
