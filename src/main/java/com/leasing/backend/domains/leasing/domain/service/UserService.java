package com.leasing.backend.domains.leasing.domain.service;

import com.leasing.backend.domains.leasing.domain.entities.User;
import com.leasing.backend.domains.leasing.resources.LoginUserResource;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User registerUser(User user);
    User loginUser(LoginUserResource user);
}
