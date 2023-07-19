package com.example.springdatabasicdemo.controllers.UsersController;

import com.example.springdatabasicdemo.dtos.UsersDto;
import com.example.springdatabasicdemo.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UsersService<Integer> usersService;

    @GetMapping("")
    public List<UsersDto> getAllUsers() {
        return usersService.getAll();
    }

    @GetMapping("/{id}")
    public UsersDto getUserById(@PathVariable Integer id) {
        return usersService.findUsers(id).orElse(null);
    }

    @PostMapping("")
    public UsersDto createUser(@RequestBody UsersDto usersDto) {
        return usersService.registerUsers(usersDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        usersService.expelUsers(id);
    }
}
