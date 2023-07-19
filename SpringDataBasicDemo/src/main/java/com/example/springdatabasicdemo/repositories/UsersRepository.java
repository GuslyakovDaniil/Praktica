package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    @Query("SELECT u FROM Users u JOIN u.author a WHERE a.full_name = :full_name")
    List<Users> findAllByAuthorFullName(@Param("full_name") String fullName);
}


