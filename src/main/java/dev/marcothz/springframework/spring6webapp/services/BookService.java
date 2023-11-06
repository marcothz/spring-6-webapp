package dev.marcothz.springframework.spring6webapp.services;

import dev.marcothz.springframework.spring6webapp.domain.Book;

public interface BookService {
    Iterable<Book> findAll();
}
