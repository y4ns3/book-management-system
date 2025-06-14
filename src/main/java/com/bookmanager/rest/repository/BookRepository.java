package com.bookmanager.rest.repository;

import com.bookmanager.rest.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
