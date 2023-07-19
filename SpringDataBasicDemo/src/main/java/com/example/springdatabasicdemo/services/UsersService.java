package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.UsersDto;
import com.example.springdatabasicdemo.models.Users;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UsersService<ID> {

    UsersDto registerUsers(UsersDto users);

    void expelUsers(UsersDto users);

    void expelUsers(ID id);

    Optional<UsersDto> findUsers(ID id);

    List<UsersDto> getAll();
}

