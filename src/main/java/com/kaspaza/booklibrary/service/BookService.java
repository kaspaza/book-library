package com.kaspaza.booklibrary.service;

import com.kaspaza.booklibrary.domain.Author;
import com.kaspaza.booklibrary.domain.Book;
import com.kaspaza.booklibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(b -> books.add(b));
        return books;
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
//    public void saveOrUpdate(Set<Book> books) {
//        bookRepository.saveAll(books);
//    }

    public void update(Book book, int bookID) {
        bookRepository.save(book);
    }


}
