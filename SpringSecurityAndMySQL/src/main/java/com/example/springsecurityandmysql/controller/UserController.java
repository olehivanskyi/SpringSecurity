package com.example.springsecurityandmysql.controller;

import com.example.springsecurityandmysql.model.User;
import com.example.springsecurityandmysql.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    private List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    private String getUserNameById(@PathVariable final Long id) {
        return userService.getUserNameById(id);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteUserNameById(@PathVariable final Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}