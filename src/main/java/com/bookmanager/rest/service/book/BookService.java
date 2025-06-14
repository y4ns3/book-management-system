package com.bookmanager.rest.service.book;

import com.bookmanager.rest.entity.Author;
import com.bookmanager.rest.entity.Book;
import com.bookmanager.rest.entity.Genre;
import com.bookmanager.rest.exceptions.AlreadyExistsException;
import com.bookmanager.rest.exceptions.NotFoundException;
import com.bookmanager.rest.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService implements  IBookService {

    private final BookRepository repo;
    @Override
    public void addBook(Book book) {
        repo.findById(book.getId())
                .ifPresentOrElse(
                        a ->{throw new AlreadyExistsException("book is already exists");}
                        ,()->repo.save(book)
                );
    }

    @Override
    public void deleteBook(Long id) {
        repo.findById(id)
                .ifPresentOrElse(book -> repo.deleteById(id)
                        , ()->{throw new NotFoundException("book is not found");}
                );
    }

    @Override
    public Book getBookById(long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NotFoundException("book is not found"));
    }

    @Override
    public Book getBookByTitle(String title) {
        return repo.findByTitle(title);
    }
    @Override
    public List<Book> getBookByGenre(Genre genre) {
        return repo.findByGenre(genre);
    }

    @Override
    public List<Book> getBookByAuthor(Author author) {
        return repo.findByAuthor(author);
    }
    @Override
    public List<Book> getAllBooks() {
        return repo.findAll();
    }

}
