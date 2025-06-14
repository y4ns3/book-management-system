package com.bookmanager.rest.service.genre;

import com.bookmanager.rest.entity.Genre;

import java.util.List;

public interface IGenreService {
    void addGenre(Genre genre);
    void deleteGenre(long id);
    Genre getGenreById(long id);
    List<Genre> getAllGenre();
}
