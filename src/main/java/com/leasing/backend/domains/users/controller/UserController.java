package com.leasing.backend.domains.users.controller;

import com.leasing.backend.domains.users.domain.service.UserService;
import com.leasing.backend.domains.users.mapping.UserMapper;
import com.leasing.backend.domains.users.resource.UserRequestResource;
import com.leasing.backend.domains.users.resource.UserResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @CrossOrigin(origins = "*")
    @GetMapping
    public Page<UserResource> getAllUser(Pageable pageable) {
        return mapper.modelListPage(userService.getAll(), pageable);
    }
    @CrossOrigin(origins = "*")
    @PutMapping("{user_id}")
    public UserResource updateUser(@PathVariable Long user_id, @RequestBody UserRequestResource resource) {
        return mapper.toResource(userService.update(user_id, mapper.toModelE(resource)));
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping("{user_id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long user_id) {
        return userService.delete(user_id);
    }

}
