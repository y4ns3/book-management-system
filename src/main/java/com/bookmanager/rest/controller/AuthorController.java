package com.bookmanager.rest.controller;

import com.bookmanager.rest.entity.Author;
import com.bookmanager.rest.exceptions.AlreadyExistsException;
import com.bookmanager.rest.exceptions.NotFoundException;
import com.bookmanager.rest.service.author.IAuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/authors")
public class AuthorController {
    private final IAuthorService authorService;

    @PostMapping
    public ResponseEntity<String> addAuthor(@RequestBody Author author){
        try{
            authorService.addAuthor(author);
            return ResponseEntity.ok("author successfully added");
        }catch(AlreadyExistsException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable long id){
        try{
            authorService.deleteAuthor(id);
            return ResponseEntity.ok("author successfully deleted");
        }catch(NotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable long id){
        try{
            Author author = authorService.getAuthorById(id);
            return ResponseEntity.ok(author);
        }catch(NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping
    public List<Author>getAllAuthors(){
        return authorService.getAllAuthors();
    }

}
