package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.AuthorDto;
import com.example.springdatabasicdemo.models.Author;
import com.example.springdatabasicdemo.models.Book;
import com.example.springdatabasicdemo.models.Book_author;
import com.example.springdatabasicdemo.repositories.AuthorRepository;
import com.example.springdatabasicdemo.repositories.BookAuthorRepository;
import com.example.springdatabasicdemo.repositories.BookRepository;
import com.example.springdatabasicdemo.services.AuthorService;
import com.example.springdatabasicdemo.services.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService<Integer> {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookAuthorRepository bookAuthorRepository;

    @Autowired
    private BookService<Integer> bookService;

    @Override
    public AuthorDto register(AuthorDto author) {
        Author newAuthor = modelMapper.map(author, Author.class);
        return modelMapper.map(authorRepository.save(newAuthor), AuthorDto.class);
    }

    @Override
    public void addBookAuthor(Book_author bookAuthor) {
        // Получить книгу и автора по их идентификаторам
        Book book = bookRepository.findById(bookAuthor.getId().getBookId()).orElse(null);
        Author author = authorRepository.findById(bookAuthor.getId().getAuthorId()).orElse(null);

        if (book != null && author != null) {
            // Устанавливаем связь между книгой и автором
            bookAuthor.setBook(book);
            bookAuthor.setAuthor(author);

            // Сохраняем связь между книгой и автором
            bookAuthorRepository.save(bookAuthor);
        }
    }


    @Override
    public void expelAuthor(AuthorDto author) {
        authorRepository.deleteById(author.getId());
    }

    @Override
    public void expelAuthor(Integer id) {
        authorRepository.deleteById(id);
    }

    @Override
    public Optional<AuthorDto> findAuthor(Integer id) {
        Optional<Author> authorOptional = authorRepository.findById(id);
        return authorOptional.map(author -> modelMapper.map(author, AuthorDto.class));
    }

    @Override
    public List<AuthorDto> getAll() {
        return authorRepository.findAll()
                .stream()
                .map(author -> modelMapper.map(author, AuthorDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<AuthorDto> findAllByFullName(String full_name) {
        return authorRepository.findAllByFullName(full_name)
                .stream()
                .map((s) -> modelMapper.map(s, AuthorDto.class))
                .collect(Collectors.toList());
    }
}
