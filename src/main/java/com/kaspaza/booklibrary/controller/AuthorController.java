package com.kaspaza.booklibrary.controller;

import com.kaspaza.booklibrary.domain.Author;
import com.kaspaza.booklibrary.service.AuthorService;
import com.kaspaza.booklibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    AuthorService authorService;
    @Autowired
    BookService bookService;

    @GetMapping("/authors")
    private List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/author/{authorId}")
    private Author getAuthors(@PathVariable("authorId") int authorId) {
        return authorService.getAuthorById(authorId);
    }

    @DeleteMapping("/author/{authorId}")
    private void deleteAuthor(@PathVariable("authorId") int authorId) {
        authorService.delete(authorId);
    }

    @PostMapping("/author")
    private int saveAuthor(@RequestBody Author author) {
        bookService.saveOrUpdate(author.getBooks());
        authorService.saveOrUpdate(author);
        return author.getID();
    }

    @PutMapping("/author")
    private Author updateAuthor(@RequestBody Author author) {
        authorService.saveOrUpdate(author);
        return author;
    }

}
