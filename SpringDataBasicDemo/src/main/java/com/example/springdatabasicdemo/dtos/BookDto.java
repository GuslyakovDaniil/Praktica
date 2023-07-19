package com.example.springdatabasicdemo.dtos;

import com.example.springdatabasicdemo.models.Author;

public class BookDto {
    private int id;
    private AuthorDto author;
    private int pages;
    private String title;
    private String description;
    private String genre;
    private int authorId;
    private int estimationId;
    private Integer bookId;

    public BookDto() {
    }

    public BookDto(int id, int pages, String title, String description, String genre) {
        this.id = id;
        this.pages = pages;
        this.title = title;
        this.description = description;
        this.genre = genre;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getEstimationId() {
        return estimationId;
    }

    public void setEstimationId(int estimationId) {
        this.estimationId = estimationId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public AuthorDto getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDto author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book { id=" + id + ", title=" + title + ", pages=" + pages + ", genre=" + genre + ", description=" + description + " }";
    }
}
