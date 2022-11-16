package com.leasing.backend.domains.users.domain.service;

import com.leasing.backend.domains.users.domain.entities.User;
import com.leasing.backend.domains.users.resource.UserResource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> getAll();
    public User create(UserResource userResource);
    User update(Long user_id, User request);
    ResponseEntity<?> delete(Long user_id);
}
