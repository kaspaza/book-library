package com.kaspaza.booklibrary.mapper;

import com.kaspaza.booklibrary.domain.Author;
import com.kaspaza.booklibrary.domain.Book;
import com.kaspaza.booklibrary.dto.AuthorDto;
import com.kaspaza.booklibrary.dto.BookDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {

    public List<BookDto> booksToBooksDto(List<Book> books){
        List<BookDto> booksDto = books
                .stream()
                .map(this::bookToDto)
                .collect(Collectors.toList());

        return booksDto;
    }

    public BookDto bookToDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setID(book.getID());
        bookDto.setTitle(book.getTitle());
        bookDto.setIsbn(book.getIsbn());
        bookDto.setAuthorsDto(book.getAuthors()
                .stream()
                .map(this::authorToDto)
                .collect(Collectors.toSet()));

        return bookDto;
    }

    public AuthorDto authorToDto(Author author) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setID(author.getID());
        authorDto.setFirstName(author.getFirstName());
        authorDto.setLastName(author.getLastName());

        return authorDto;
    }

}
