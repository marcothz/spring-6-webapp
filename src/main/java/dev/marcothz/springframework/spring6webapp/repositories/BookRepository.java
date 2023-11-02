package dev.marcothz.springframework.spring6webapp.repositories;

import dev.marcothz.springframework.spring6webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
