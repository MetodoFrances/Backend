package com.leasing.backend.users.controller;

import com.leasing.backend.users.domain.service.UserService;
import com.leasing.backend.users.mapping.UserMapper;
import com.leasing.backend.users.resource.UserRequestResource;
import com.leasing.backend.users.resource.UserResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping
    public ResponseEntity<UserResource> createUser(@RequestBody UserRequestResource resource) {
        return new ResponseEntity<>(mapper.toResource(userService.create(
                mapper.toModel(resource))), HttpStatus.CREATED);
    }
    @CrossOrigin(origins = "*")
    @PutMapping("{user_id}")
    public UserResource updateUser(@PathVariable String user_id, @RequestBody UserRequestResource resource) {
        return mapper.toResource(userService.update(user_id, mapper.toModel(resource)));
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping("{user_id}")
    public ResponseEntity<?> deleteUser(@PathVariable String user_id) {
        return userService.delete(user_id);
    }

}
