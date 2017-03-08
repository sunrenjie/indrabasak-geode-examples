package com.basaki.example.geode.spring.service;

import com.basaki.example.geode.spring.model.Book;
import com.basaki.example.geode.spring.model.BookRequest;
import com.basaki.example.geode.spring.repository.BookRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * {@code BookService} service provides data access service for {@code Book}.
 * <p/>
 *
 * @author Indra Basak
 * @sice 2/23/17
 */
@Service
@Slf4j
public class BookService {

    @Autowired
    private BookRepository repo;

    public Book create(BookRequest request) {
        Assert.notNull(request.getTitle());
        Assert.notNull(request.getAuthor());

        Book book =
                new Book(UUID.randomUUID(), request.getTitle().toUpperCase(),
                        request.getAuthor().toUpperCase());
        return repo.save(book);
    }

    public Book getById(UUID id) {
        return repo.findById(id);
    }

    public List<Book> get(String title, String author) {
        Iterable<Book> books;
        if (title != null && author == null) {
            books = repo.findByTitle(title.toUpperCase());
        } else if (title == null && author != null) {
            books = repo.findByAuthor(author.toUpperCase());
        } else if (title != null && author != null) {
            books = repo.findByTitleAndAuthor(title.toUpperCase(),
                    author.toUpperCase());
        } else {
            books = repo.findAll();
        }

        List<Book> list = new ArrayList<>();
        books.forEach(list::add);
        return list;
    }

    public void delete(UUID id) {
        repo.delete(id);
    }

    public void deleteAll() {
        repo.deleteAll();
    }
}
