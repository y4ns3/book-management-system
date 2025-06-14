package com.bookmanager.rest.repository;

import com.bookmanager.rest.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
