package com.bookmanager.rest.controller;

import com.bookmanager.rest.entity.Genre;
import com.bookmanager.rest.exceptions.AlreadyExistsException;
import com.bookmanager.rest.exceptions.NotFoundException;
import com.bookmanager.rest.service.genre.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/genres")
public class GenreController {
    private final GenreService genreService;
    @PostMapping
    public ResponseEntity<String> addGenre(@RequestBody Genre genre){
        try{
            genreService.addGenre(genre);
            return ResponseEntity.ok("Genre added");
        }catch(AlreadyExistsException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping
    public List<Genre> getAllGenres(){
        return genreService.getAllGenre();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Genre> getById(@PathVariable long id){
        try{
            Genre genre = genreService.getGenreById(id);
            return ResponseEntity.ok(genre);
        }catch(NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGenre(@PathVariable long id){
        try{
            genreService.deleteGenre(id);
            return ResponseEntity.ok("Genre deleted");
        }catch(NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }




}
