package com.kaspaza.booklibrary.service;

import com.kaspaza.booklibrary.domain.Book;
import com.kaspaza.booklibrary.dto.BookDto;
import com.kaspaza.booklibrary.mapper.BookMapper;
import com.kaspaza.booklibrary.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookMapper bookMapper;

    public List<BookDto> getAllBooks() {
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(b -> books.add(b));
        return bookMapper.booksToBooksDto(books);
    }

        public List<BookDto> getAvailableBooks() {
        List<Book> availableBooks = bookRepository
                .findAll()
                .stream()
                .filter(Book::isAvailable)
                .collect(Collectors.toList());
        return bookMapper.booksToBooksDto(availableBooks);
    }


    public Book getBookById(Integer id) {
        return bookRepository.findById(id).get();
    }

    public void delete(Integer id) {
        bookRepository.deleteById(id);
    }

    public void saveOrUpdate(Book book) {
        bookRepository.save(book);
    }

    public void saveOrUpdate(Set<Book> books) {
        bookRepository.saveAll(books);
    }

    public void update(Book book, int bookId) {
        bookRepository.save(book);
    }
}
