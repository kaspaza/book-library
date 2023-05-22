package com.kaspaza.booklibrary.mapper;

import com.kaspaza.booklibrary.domain.User;
import com.kaspaza.booklibrary.domain.Book;
import com.kaspaza.booklibrary.dto.UserDto;
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
        bookDto.setId(book.getId());
        bookDto.setTitle(book.getTitle());
        bookDto.setIsbn(book.getIsbn());
        bookDto.setAvailable(book.isAvailable());
        bookDto.setAuthorsDto(book.getAuthors()
                .stream()
                .map(this::userToDto)
                .collect(Collectors.toSet()));

        return bookDto;
    }

    public UserDto userToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());

        return userDto;
    }

}
