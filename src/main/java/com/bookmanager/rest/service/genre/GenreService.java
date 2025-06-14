package com.bookmanager.rest.service.genre;

import com.bookmanager.rest.entity.Genre;
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
                        a ->{throw new RuntimeException("already exists");}
                        ,()->repo.save(genre));

    }

    @Override
    public void deleteGenre(long id) {
        repo.findById(id)
                .ifPresentOrElse(genre -> repo.deleteById(id)
                        , ()->{throw new RuntimeException("not found");}
                );
    }

    @Override
    public Genre getGenreById(long id) {
        return repo.findById(id).orElseThrow(()->new RuntimeException("not exists"));
    }

    @Override
    public List<Genre> getAllGenre() {
        return repo.findAll();
    }
}
