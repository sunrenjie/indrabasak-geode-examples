package com.basaki.example.geode.spring.repository;

import com.basaki.example.geode.spring.model.Book;
import java.util.UUID;
import org.springframework.data.gemfire.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * {@code BookRepository} exposes all CRUD operations on a repository of type
 * {@code Book}.
 * <p/>
 *
 * @author Indra Basak
 * @since 2/22/17
 */
public interface BookRepository extends CrudRepository<Book, UUID> {
    Book findById(UUID id);

    @Query("SELECT * FROM /Book b WHERE b.title = $1 ")
    Iterable<Book> findByTitle(String title);

    @Query("SELECT * FROM /Book b WHERE b.author = $1 ")
    Iterable<Book> findByAuthor(String author);

    @Query("SELECT * FROM /Book b WHERE b.title = $1 AND b.author = $2 ")
    Iterable<Book> findByTitleAndAuthor(String title, String author);
}
