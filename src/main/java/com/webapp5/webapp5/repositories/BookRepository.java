package com.webapp5.webapp5.repositories;

import com.webapp5.webapp5.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
