package com.kaspaza.booklibrary.controller;

import com.kaspaza.booklibrary.domain.Book;
import com.kaspaza.booklibrary.dto.BookDto;
import com.kaspaza.booklibrary.service.UserService;
import com.kaspaza.booklibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;
    @Autowired
    UserService userService;

    @GetMapping("/books")
    private List<BookDto> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/booksAvailable")
    private List<BookDto> getAvailableBooks() {
        return bookService.getAvailableBooks();
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
        userService.saveOrUpdate(book.getAuthors());
        bookService.saveOrUpdate(book);
        return book.getId();
    }

    @PutMapping("/book")
    private Book updateBook(@RequestBody Book book) {
        bookService.saveOrUpdate(book);
        return book;
    }
}
