package com.leasing.backend.domains.leasing.controllers;

import com.leasing.backend.domains.leasing.domain.service.UserService;
import com.leasing.backend.domains.leasing.mapping.UserMapper;
import com.leasing.backend.domains.leasing.resources.RegisterUserResource;
import com.leasing.backend.domains.leasing.resources.UserResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/register")
public class RegisterController {
    @Autowired
    private final UserService userService;

    private final UserMapper mapper;

    public RegisterController(UserService loanService, UserMapper mapper) {
        this.userService = loanService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<UserResource> registerUser(@RequestBody RegisterUserResource resource) {
        return new ResponseEntity<>(
                this.mapper.toResource(
                        this.userService.registerUser(
                                this.mapper.toModel(resource)
                        )
                ),
                HttpStatus.CREATED
        );
    }
}
