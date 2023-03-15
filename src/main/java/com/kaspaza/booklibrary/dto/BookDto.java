package com.kaspaza.booklibrary.dto;

import java.util.Set;

public class BookDto {
    private Integer ID;
    private String title;
    private String isbn;
    private Set<AuthorDto> authorsDto;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
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

    public Set<AuthorDto> getAuthorsDto() {
        return authorsDto;
    }

    public void setAuthorsDto(Set<AuthorDto> authorsDto) {
        this.authorsDto = authorsDto;
    }
}
