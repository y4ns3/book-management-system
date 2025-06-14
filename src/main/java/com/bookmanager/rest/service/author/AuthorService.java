package com.bookmanager.rest.service.author;

import com.bookmanager.rest.entity.Author;
import com.bookmanager.rest.exceptions.AlreadyExistsException;
import com.bookmanager.rest.exceptions.NotFoundException;
import com.bookmanager.rest.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorService implements IAuthorService {
    private final AuthorRepository repo;

    @Override
    public void addAuthor(Author author) {
        Author a = repo.findByName(author.getName());
        if (a != null) {
            throw new AlreadyExistsException("Author already exists");
        }
        repo.save(author);
    }


    @Override
    public void deleteAuthor(long id) {
        repo.findById(id)
                .ifPresentOrElse(
                        author -> repo.deleteById(id)
                        ,()->{throw new NotFoundException("author is not found");}
                );
    }

    @Override
    public Author getAuthorById(long id) {
        return repo.findById(id).orElseThrow(() -> new NotFoundException("author is not found"));
    }

    @Override
    public Author getAuthorByName(String name) {
        return repo.findByName(name);
    }

    @Override
    public List<Author> getAllAuthors() {
        return repo.findAll();
    }
}
