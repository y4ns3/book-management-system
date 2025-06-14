package com.bookmanager.rest.controller;

import com.bookmanager.rest.entity.Book;
import com.bookmanager.rest.exceptions.AlreadyExistsException;
import com.bookmanager.rest.service.book.BookService;
import com.bookmanager.rest.service.book.IBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/v1/books")
public class BookController {
    private final IBookService bookService;

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
        return bookService.
    }
}
