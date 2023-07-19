package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.dtos.BookDto;
import com.example.springdatabasicdemo.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Transactional
    @Modifying
    @Query("SELECT b FROM Book b WHERE b.title = :title")
    List<Book> findAllByTitle(@Param("title") String title);

    @Modifying
    @Query(value = "INSERT INTO book_author (book_id, author_id) VALUES (:bookId, :authorId)", nativeQuery = true)
    void addBookAuthor(@Param("bookId") Integer bookId, @Param("authorId") Integer authorId);
}
