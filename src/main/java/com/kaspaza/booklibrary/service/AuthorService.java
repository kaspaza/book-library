package com.kaspaza.booklibrary.service;

import com.kaspaza.booklibrary.domain.Author;
import com.kaspaza.booklibrary.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        List<Author> authors = new ArrayList<>();
        authorRepository.findAll().forEach(a -> authors.add(a));
        return authors;
    }

    public Author getAuthorById(Integer id) {
        return authorRepository.findById(id).get();
    }

    public void saveOrUpdate(Author author) {
        authorRepository.save(author);
    }

    public void saveOrUpdate(Set<Author> authors) {
        authorRepository.saveAll(authors);
    }

    public void delete(Integer id) {
        authorRepository.deleteById(id);
    }

    public void update(Author author, int authorID) {
        authorRepository.save(author);
    }
}
