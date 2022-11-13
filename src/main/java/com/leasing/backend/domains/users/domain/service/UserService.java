package com.leasing.backend.domains.users.domain.service;

import com.leasing.backend.domains.users.domain.entities.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User create(User user);
    User update(String user_id, User request);
    ResponseEntity<?> delete(String user_id);
}
