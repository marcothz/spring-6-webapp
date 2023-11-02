package dev.marcothz.springframework.spring6webapp.repositories;

import dev.marcothz.springframework.spring6webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
