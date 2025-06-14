package com.bookmanager.rest.repository;

import com.bookmanager.rest.entity.Author;
import com.bookmanager.rest.entity.Book;
import com.bookmanager.rest.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {
    List<Book> findByAuthor(Author author);
    List<Book> findByGenre(Genre genre);
    Book findByTitle(String title);
}
