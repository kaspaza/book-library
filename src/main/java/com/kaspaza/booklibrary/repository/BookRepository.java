package com.kaspaza.booklibrary.repository;

import com.kaspaza.booklibrary.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
