package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.Book;
import com.example.springdatabasicdemo.models.Estimation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EstimationRepository extends JpaRepository<Estimation, Integer> {
    @Transactional
    @Modifying
    @Query("SELECT b FROM Book b WHERE b.estimationId IN (SELECT e.id FROM Estimation e WHERE e.mark = :mark)")
    List<Book> findBooksByMark(@Param("mark") double mark);
}
