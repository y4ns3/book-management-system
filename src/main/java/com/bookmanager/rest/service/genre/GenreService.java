package com.bookmanager.rest.service.genre;

import com.bookmanager.rest.entity.Genre;
import com.bookmanager.rest.exceptions.AlreadyExistsException;
import com.bookmanager.rest.exceptions.NotFoundException;
import com.bookmanager.rest.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreService implements IGenreService{
    private GenreRepository repo;
    
    @Override
    public void addGenre(Genre genre) {
        repo.findById(genre.getId())
                .ifPresentOrElse(
                        a ->{throw new AlreadyExistsException("genre is already exists");}
                        ,()->repo.save(genre));

    }

    @Override
    public void deleteGenre(long id) {
        repo.findById(id)
                .ifPresentOrElse(genre -> repo.deleteById(id)
                        , ()->{throw new NotFoundException("genre is not found");}
                );
    }

    @Override
    public Genre getGenreById(long id) {
        return repo.findById(id).orElseThrow(()->new NotFoundException("genre is not found"));
    }

    @Override
    public List<Genre> getAllGenre() {
        return repo.findAll();
    }

    @Override
    public Genre getGenreByName(String name) {
        return repo.getByName(name);
    }
}
