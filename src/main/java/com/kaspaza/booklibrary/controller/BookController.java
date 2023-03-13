package com.kaspaza.booklibrary.controller;

import com.kaspaza.booklibrary.domain.Book;
import com.kaspaza.booklibrary.service.AuthorService;
import com.kaspaza.booklibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;
    @Autowired
    AuthorService authorService;

    @GetMapping("/books")
    private List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/book/{bookId}")
    private Book getBook(@PathVariable("bookId") int bookId) {
        return bookService.getBookById(bookId);
    }

    @DeleteMapping("/book/{bookId}")
    private void deleteBook(@PathVariable("bookId") int bookId) {
        bookService.delete(bookId);
    }

    @PostMapping("/book")
    private int saveBook(@RequestBody Book book) {
        authorService.saveOrUpdate(book.getAuthors());
        bookService.saveOrUpdate(book);
        return book.getID();
    }

    @PutMapping("/book")
    private Book updateBook(@RequestBody Book book) {
        bookService.saveOrUpdate(book);
        return book;
    }
}
