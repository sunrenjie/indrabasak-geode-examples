package com.basaki.example.geode.spring.model;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.Region;

/**
 * {@code Book} represents a book entity used in Spring boot and Geode example.
 * <p/>
 *
 * @author Indra Basak
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Region("Book")
public class Book {
    @Id
    private UUID id;
    private String title;
    private String author;
}
