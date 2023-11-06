package dev.marcothz.springframework.spring6webapp.repositories;

import dev.marcothz.springframework.spring6webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
