package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.BookDto;
import com.example.springdatabasicdemo.models.Book;
import com.example.springdatabasicdemo.models.Book_author;
import com.example.springdatabasicdemo.repositories.AuthorRepository;
import com.example.springdatabasicdemo.repositories.BookRepository;
import com.example.springdatabasicdemo.services.BookService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class BookServiceImpl implements BookService<Integer> {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public BookDto registerBook(BookDto bookDto) {
        Book book = modelMapper.map(bookDto, Book.class); // Отображение BookDto на сущность Book
        Book savedBook = bookRepository.save(book); // Сохранение сущности книги в базу данных
        return modelMapper.map(savedBook, BookDto.class); // Отображение сохраненной книги обратно на BookDto
    }


    @Override
    public void expelBook(BookDto book) {
        bookRepository.deleteById(book.getId());
    }

    @Override
    public void expelBook(Integer id) {
        bookRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void addBookAuthor(Book_author bookAuthor) {
        bookRepository.addBookAuthor(bookAuthor.getBookId(), bookAuthor.getAuthorId());
    }


    @Override
    public Optional<BookDto> findBook(Integer id) {
        return Optional.ofNullable(modelMapper.map(bookRepository.findById(id), BookDto.class));
    }


    @Override
    public List<BookDto> getAll() {
        return bookRepository.findAll().stream().map((b) -> modelMapper.map(b, BookDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<BookDto> findBookByTitle(String title) {
            List<Book> books = bookRepository.findAllByTitle(title);
            return books.stream()
                    .map(book -> modelMapper.map(book, BookDto.class))
                    .collect(Collectors.toList());
        }
    }

