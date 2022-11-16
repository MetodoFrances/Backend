package com.leasing.backend.domains.users.domain.service;

import com.leasing.backend.domains.users.domain.entities.User;
<<<<<<< HEAD
import com.leasing.backend.domains.users.resource.UserResource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> getAll();
    public User create(UserResource userResource);
    User update(Long user_id, User request);
    ResponseEntity<?> delete(Long user_id);
=======
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User create(User user);
    User update(String user_id, User request);
    ResponseEntity<?> delete(String user_id);
>>>>>>> 09f2fd92806be7df8c5ef6720bf9a57fb76eccfd
}
