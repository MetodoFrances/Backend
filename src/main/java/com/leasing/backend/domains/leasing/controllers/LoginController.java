package com.leasing.backend.domains.leasing.controllers;

import com.leasing.backend.domains.leasing.domain.service.UserService;
import com.leasing.backend.domains.leasing.mapping.UserMapper;
import com.leasing.backend.domains.leasing.resources.LoginUserResource;
import com.leasing.backend.domains.leasing.resources.RegisterUserResource;
import com.leasing.backend.domains.leasing.resources.UserResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/login")
public class LoginController {
    @Autowired
    private final UserService userService;

    private final UserMapper mapper;

    public LoginController(UserService userService, UserMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }
    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<UserResource> loginUser(@RequestBody LoginUserResource resource) {
        return new ResponseEntity<>(
                this.mapper.toResource(
                        this.userService.loginUser(resource)
                ),
                HttpStatus.OK
        );
    }
}
