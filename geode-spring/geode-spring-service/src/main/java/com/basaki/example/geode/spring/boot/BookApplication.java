package com.basaki.example.geode.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * {@code BookApplication} represents the entry point for book controller
 * spring boot application.
 * <p/>
 *
 * @author Indra Basak
 * @since 2/23/17
 */
@SpringBootApplication
@ComponentScan(basePackages = {
        "com.basaki.example.geode.spring.config",
        "com.basaki.example.geode.spring.controller",
        "com.basaki.example.geode.spring.model",
        "com.basaki.example.geode.spring.repository",
        "com.basaki.example.geode.spring.service"})
public class BookApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookApplication.class, args);
    }
}
