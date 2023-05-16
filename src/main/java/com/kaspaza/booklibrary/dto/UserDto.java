package com.kaspaza.booklibrary.dto;

import java.util.Set;

public class UserDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private Set<BookDto> booksWrittenDto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<BookDto> getBooksWrittenDto() {
        return booksWrittenDto;
    }

    public void setBooksWrittenDto(Set<BookDto> booksWrittenDto) {
        this.booksWrittenDto = booksWrittenDto;
    }
}
