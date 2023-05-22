package com.kaspaza.booklibrary.mapper;

import com.kaspaza.booklibrary.domain.User;
import com.kaspaza.booklibrary.domain.Book;
import com.kaspaza.booklibrary.dto.UserDto;
import com.kaspaza.booklibrary.dto.BookDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public List<UserDto> usersToUsersDto(List<User> users) {
        List<UserDto> usersDto = users
                .stream()
                .map(this::userToDto)
                .collect(Collectors.toList());

        return usersDto;
    }

    public UserDto userToDto(User user) {
        Integer ID = user.getId();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();

        Set<BookDto> booksDto = user
                .getBooksWritten()
                .stream()
                .map(this::bookToDto)
                .collect(Collectors.toSet());

        UserDto userDto = new UserDto();
        userDto.setId(ID);
        userDto.setFirstName(firstName);
        userDto.setLastName(lastName);
        userDto.setBooksWrittenDto(booksDto);

        return userDto;
    }

    public BookDto bookToDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setTitle(book.getTitle());
        bookDto.setIsbn(book.getIsbn());
        bookDto.setAvailable(book.isAvailable());

        return bookDto;
    }

}
