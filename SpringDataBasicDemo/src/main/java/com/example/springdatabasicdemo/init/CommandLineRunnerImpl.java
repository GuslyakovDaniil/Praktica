package com.example.springdatabasicdemo.init;

import com.example.springdatabasicdemo.dtos.AuthorDto;
import com.example.springdatabasicdemo.dtos.BookDto;
import com.example.springdatabasicdemo.dtos.EstimationDto;
import com.example.springdatabasicdemo.dtos.UsersDto;
import com.example.springdatabasicdemo.models.Users;
import com.example.springdatabasicdemo.repositories.AuthorRepository;
import com.example.springdatabasicdemo.repositories.BookRepository;
import com.example.springdatabasicdemo.repositories.EstimationRepository;
import com.example.springdatabasicdemo.repositories.UsersRepository;
import com.example.springdatabasicdemo.services.AuthorService;
import com.example.springdatabasicdemo.services.BookService;
import com.example.springdatabasicdemo.services.EstimationService;
import com.example.springdatabasicdemo.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.nio.file.Path;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import java.util.Optional;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final AuthorService<Integer> authorService;
    private final BookService<Integer> bookService;
    private final EstimationService<Integer> estimationService;
    private final UsersService<Integer> usersService;
    private final UsersRepository usersRepository;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final EstimationRepository estimationRepository;

    @Autowired
    public CommandLineRunnerImpl(AuthorService<Integer> authorService, BookService<Integer> bookService,
                                 EstimationService<Integer> estimationService, UsersService<Integer> usersService, UsersRepository usersRepository, AuthorRepository authorRepository, BookRepository bookRepository, EstimationRepository estimationRepository) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.estimationService = estimationService;
        this.usersService = usersService;
        this.usersRepository = usersRepository;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.estimationRepository = estimationRepository;
    }


    private void seedData() throws IOException {
        // Создание книги
        BookDto bookDto = bookService.registerBook(new BookDto(1, 200, "Название книги", "Описание книги", "Жанр книги"));

        // Создание оценки
        EstimationDto estimationDto = estimationService.registerEstimation(new EstimationDto(1, 1));

        // Создание автора
        AuthorDto authorDto = authorService.register(new AuthorDto(1, "Иван Иванов"));

        // Установка значений authorId и estimationId в созданной книге
        bookDto.setAuthorId(authorDto.getId());
        bookDto.setEstimationId(estimationDto.getId());

        // Сохранение книги с установленными значениями
        bookService.registerBook(bookDto);
    }


    @Override
    public void run(String... args) throws Exception {
        seedData();
    }

}