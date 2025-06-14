package com.bookmanager.rest.controller;

import com.bookmanager.rest.entity.Author;
import com.bookmanager.rest.entity.Book;
import com.bookmanager.rest.entity.Genre;
import com.bookmanager.rest.exceptions.AlreadyExistsException;
import com.bookmanager.rest.exceptions.NotFoundException;
import com.bookmanager.rest.service.author.IAuthorService;
import com.bookmanager.rest.service.book.IBookService;
import com.bookmanager.rest.service.genre.IGenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/books")
public class BookController {
    private final IBookService bookService;
    private final IAuthorService authorService;
    private final IGenreService genreService;
    @PostMapping
    public ResponseEntity<String> addBook(@RequestBody Book book){
        try{
            bookService.addBook(book);
            return ResponseEntity.ok("book added");
        }catch(AlreadyExistsException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id){
        try{
            bookService.deleteBook(id);
            return ResponseEntity.ok("book deleted");
        }catch(NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        try{
            Book book = bookService.getBookById(id);
            return ResponseEntity.ok(book);
        }catch(NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/title/{name}")
    public ResponseEntity<Book> getBookByTitle(@PathVariable String name){
        try{
            Book book = bookService.getBookByTitle(name);
            return  ResponseEntity.ok(book);
        }catch(NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/author/{name}")
    public ResponseEntity<List<Book>> getBooksByAuthor(@PathVariable String name){
        try{
            Author author = authorService.getAuthorByName(name);
            List<Book> books = bookService.getBookByAuthor(author);
            return ResponseEntity.ok(books);
        }catch(NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<Book>> getBooksByGenre(@RequestParam String genre){
        try{
            Genre genre = genreService.g
        }
    }


}
