package com.kaspaza.booklibrary.mapper;

import com.kaspaza.booklibrary.domain.Author;
import com.kaspaza.booklibrary.domain.Book;
import com.kaspaza.booklibrary.dto.AuthorDto;
import com.kaspaza.booklibrary.dto.BookDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Component
public class AuthorMapper {

    public List<AuthorDto> authorsToAuthorsDto(List<Author> authors) {
        List<AuthorDto> authorsDto = authors
                .stream()
                .map(this::authorToDto)
                .collect(Collectors.toList());

        return authorsDto;
    }

    public AuthorDto authorToDto(Author author) {
        Integer ID = author.getID();
        String firstName = author.getFirstName();
        String lastName = author.getLastName();

        Set<BookDto> booksDto = author
                .getBooks()
                .stream()
                .map(this::bookToDto)
                .collect(Collectors.toSet());

        AuthorDto authorDto = new AuthorDto();
        authorDto.setID(ID);
        authorDto.setFirstName(firstName);
        authorDto.setLastName(lastName);
        authorDto.setBooksDto(booksDto);

        return authorDto;
    }

    public BookDto bookToDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setID(book.getID());
        bookDto.setTitle(book.getTitle());
        bookDto.setIsbn(book.getIsbn());

        return bookDto;
    }

}
