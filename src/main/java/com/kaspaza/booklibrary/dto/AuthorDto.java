package com.kaspaza.booklibrary.dto;

import java.util.Set;

public class AuthorDto {
    private Integer ID;
    private String firstName;
    private String lastName;
    private Set<BookDto> booksDto;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
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

    public Set<BookDto> getBooksDto() {
        return booksDto;
    }

    public void setBooksDto(Set<BookDto> booksDto) {
        this.booksDto = booksDto;
    }
}
