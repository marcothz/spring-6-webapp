package dev.marcothz.springframework.spring6webapp.services;

import dev.marcothz.springframework.spring6webapp.domain.Author;

public interface AuthorService {
    public Iterable<Author> findAll();
}
