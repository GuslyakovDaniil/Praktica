package com.example.springdatabasicdemo.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book extends BaseEntity {

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private Set<Book_author> book_author;

    @Column(name = "title", length = 225)
    private String title;

    @Column(name = "pages")
    private Integer pages;

    @Column(name = "genre")
    private String genre;

    @Column(name = "description")
    private String description;

    @Column(name = "estimation_id")
    private Integer estimationId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getEstimationId() {
        return estimationId;
    }

    public void setEstimationId(Integer estimationId) {
        this.estimationId = estimationId;
    }

    public Book() {
    }

    protected Book(Integer id, String title, Integer pages, String genre, String description) {
        super(id);
        book_author = new HashSet<Book_author>();
        this.title = title;
        this.pages = pages;
        this.genre = genre;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book { id=" + id + ", title=" + title + ", pages=" + pages + ", genre=" + genre + ", description=" + description + " }";
    }
}
