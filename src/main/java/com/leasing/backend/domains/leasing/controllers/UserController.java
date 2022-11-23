package com.leasing.backend.domains.leasing.controllers;

import com.leasing.backend.domains.leasing.domain.entities.User;
import com.leasing.backend.domains.leasing.domain.service.UserService;
import com.leasing.backend.domains.leasing.mapping.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private final UserService userService;

    private final UserMapper mapper;

    public UserController(UserService userService, UserMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }

}
