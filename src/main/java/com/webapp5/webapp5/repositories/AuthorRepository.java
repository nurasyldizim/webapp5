package com.webapp5.webapp5.repositories;

import com.webapp5.webapp5.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
