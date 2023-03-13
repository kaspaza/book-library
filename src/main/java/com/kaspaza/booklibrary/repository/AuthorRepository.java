package com.kaspaza.booklibrary.repository;

import com.kaspaza.booklibrary.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Integer> {
}
