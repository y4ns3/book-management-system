package com.bookmanager.rest.service.book;

import com.bookmanager.rest.entity.Author;
import com.bookmanager.rest.entity.Book;
import com.bookmanager.rest.entity.Genre;

import java.util.List;

public interface IBookService {
    void addBook(Book book);
    void deleteBook(Long id);
    Book getBookById(long id);
    Book getBookByTitle(String title);
    List<Book> getBookByGenre(Genre genre);
    List<Book> getBookByAuthor(Author author);
    List<Book> getAllBooks();
}
