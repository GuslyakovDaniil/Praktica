package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.UsersDto;
import com.example.springdatabasicdemo.models.Author;
import com.example.springdatabasicdemo.models.Users;
import com.example.springdatabasicdemo.repositories.AuthorRepository;
import com.example.springdatabasicdemo.repositories.UsersRepository;
import com.example.springdatabasicdemo.services.UsersService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UsersService<Integer> {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AuthorRepository authorRepository;


    @Override
    public UsersDto registerUsers(UsersDto users) {
        Users newUser = modelMapper.map(users, Users.class);

        // Сохраняем сущность Users в базе данных
        newUser = usersRepository.save(newUser);

        // Создаем новый объект Author, используя данные из UsersDto
        Author author = new Author();
        author.setFull_name(users.getFullName());
        author.setUsers(new HashSet<>(Collections.singletonList(newUser)));

        // Сохраняем сущность Author в базе данных
        author = authorRepository.save(author);

        // Обновляем связь между объектами Users и Author
        newUser.setAuthor(author);
        usersRepository.save(newUser);

        return modelMapper.map(newUser, UsersDto.class);
    }






    @Override
    public void expelUsers(UsersDto users) {
        usersRepository.deleteById(users.getId());
    }

    @Override
    public void expelUsers(Integer id) {
        usersRepository.deleteById(id);
    }

    @Override
    public Optional<UsersDto> findUsers(Integer id) {
        return Optional.ofNullable(modelMapper.map(usersRepository.findById(id), UsersDto.class));
    }

    @Override
    public List<UsersDto> getAll() {
        return usersRepository.findAll().stream().map((s) -> modelMapper.map(s, UsersDto.class)).collect(Collectors.toList());
    }



}