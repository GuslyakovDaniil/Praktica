package com.example.springdatabasicdemo.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "author")
public class Author extends BaseEntity {

    public Set<Book_author> getBook_author() {
        return book_author;
    }

    public void setBook_author(Set<Book_author> book_author) {
        this.book_author = book_author;
    }

    @OneToMany(mappedBy = "author")
    private Set<Users> users;
    @OneToMany(mappedBy = "author")
    private Set<Book_author> book_author;


    @Column(name = "full_name", length = 50)
    private String full_name;

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }
    public Set<Users> getUsers() {
        return users;
    }

    public void setUsers(Set<Users> users) {
        this.users = users;
    }
    public Author() {
    }

    protected Author(Integer id, String full_name) {
        super(id);
        book_author = new HashSet<Book_author>();
        this.full_name = full_name;
    }



    @Override
    public String toString() {
        return "Author { id=" + id + ", full_name=" + full_name + " }";
    }
}
