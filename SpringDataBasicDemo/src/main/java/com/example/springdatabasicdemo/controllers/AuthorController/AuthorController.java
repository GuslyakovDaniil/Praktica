package com.example.springdatabasicdemo.controllers.AuthorController;

import com.example.springdatabasicdemo.dtos.AuthorDto;
import com.example.springdatabasicdemo.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService<Integer> authorService;

    @Autowired
    public AuthorController(AuthorService<Integer> authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<AuthorDto> getAllAuthors() {
        return authorService.getAll();
    }

    @GetMapping("/{id}")
    public AuthorDto getAuthorById(@PathVariable Integer id) {
        return authorService.findAuthor(id).orElse(null);
    }

    @PostMapping
    public AuthorDto createAuthor(@RequestBody AuthorDto authorDto) {
        return authorService.register(authorDto);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Integer id) {
        authorService.expelAuthor(id);
    }
}
