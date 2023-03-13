package com.kaspaza.booklibrary.repository;

import com.kaspaza.booklibrary.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
}
