package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.BookDto;
import com.example.springdatabasicdemo.models.Book_author;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface BookService<ID> {
    BookDto registerBook(BookDto bookDto);

    void expelBook(BookDto book);

    void expelBook(ID id);

    void addBookAuthor(Book_author bookAuthor);

    Optional<BookDto> findBook(ID id);

    List<BookDto> getAll();

    List<BookDto> findBookByTitle(String title);
}
