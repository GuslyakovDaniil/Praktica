package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.Book_author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookAuthorRepository extends JpaRepository<Book_author, Long> {
    // Дополнительные методы, если необходимо
}

