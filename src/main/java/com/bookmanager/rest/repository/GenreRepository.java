package com.bookmanager.rest.repository;

import com.bookmanager.rest.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre,Long> {
    Genre getByName(String name);
}
