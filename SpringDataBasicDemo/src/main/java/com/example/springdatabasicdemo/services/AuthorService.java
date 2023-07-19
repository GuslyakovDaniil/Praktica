package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.AuthorDto;
import com.example.springdatabasicdemo.models.Author;
import com.example.springdatabasicdemo.models.Book_author;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface AuthorService<ID>{
    AuthorDto register(AuthorDto author);
    void addBookAuthor(Book_author bookAuthor);

    void expelAuthor(AuthorDto author);

    void expelAuthor(ID id);

    Optional<AuthorDto> findAuthor(ID id);

    List<AuthorDto> getAll();

    List<AuthorDto> findAllByFullName(String full_name);
}
