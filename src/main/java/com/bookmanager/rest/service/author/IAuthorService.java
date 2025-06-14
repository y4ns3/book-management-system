package com.bookmanager.rest.service.author;

import com.bookmanager.rest.entity.Author;

import java.util.List;

public interface IAuthorService {
    void addAuthor(Author author);
    void deleteAuthor(long id);
    Author getAuthorById(long id);
    Author getAuthorByName(String name);
    List<Author> getAllAuthors();
}
