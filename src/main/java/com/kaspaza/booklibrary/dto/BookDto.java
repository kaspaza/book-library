package com.kaspaza.booklibrary.dto;

import java.util.Set;

public class BookDto {
    private Integer id;
    private String title;
    private String isbn;
    private boolean available;
    private Set<UserDto> authorsDto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Set<UserDto> getAuthorsDto() {
        return authorsDto;
    }

    public void setAuthorsDto(Set<UserDto> authorsDto) {
        this.authorsDto = authorsDto;
    }
}
