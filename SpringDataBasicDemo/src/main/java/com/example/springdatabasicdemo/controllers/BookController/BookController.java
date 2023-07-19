package com.example.springdatabasicdemo.controllers.BookController;

import com.example.springdatabasicdemo.dtos.BookDto;
import com.example.springdatabasicdemo.models.Book;
import com.example.springdatabasicdemo.models.Book_author;
import com.example.springdatabasicdemo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService<Integer> bookService;

    @Autowired
    public BookController(BookService<Integer> bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookDto> getAllBooks() {
        return bookService.getAll();
    }

    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable Integer id) {
        return bookService.findBook(id).orElse(null);
    }

    @PostMapping
    public BookDto createBook(@RequestBody BookDto bookDto) {
        // Создание книги
        BookDto createdBook = bookService.registerBook(bookDto);

        // Установка объекта AuthorDto в книге
        createdBook.setAuthor(bookDto.getAuthor());

        // Установка значений authorId и estimationId в созданной книге
        createdBook.setAuthorId(bookDto.getAuthor().getId());
        createdBook.setEstimationId(bookDto.getEstimationId());

        // Установка estimationId в объекте Book
        Book book = new Book();
        book.setEstimationId(bookDto.getEstimationId());

        // Сохранение связи между книгой и автором
        Book_author bookAuthor = new Book_author();
        Book_author.BookAuthorId bookAuthorId = new Book_author.BookAuthorId();
        bookAuthorId.setBookId(createdBook.getBookId());
        bookAuthorId.setAuthorId(createdBook.getAuthorId());
        bookAuthor.setId(bookAuthorId);
        bookService.addBookAuthor(bookAuthor);

        return createdBook;
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Integer id) {
        bookService.expelBook(id);
    }
}
