package com.leasing.backend.users.service;

import com.leasing.backend.shared.exception.ResourceNotFoundException;
import com.leasing.backend.shared.exception.ResourceValidationException;
import com.leasing.backend.users.domain.entities.User;
import com.leasing.backend.users.domain.persistence.UserRepository;
import com.leasing.backend.users.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private static final String ENTITY = "users";

    @Autowired
    private final UserRepository userRepository;

    private final Validator validator;

    public UserServiceImpl(UserRepository userRepository, Validator validator) {
        this.userRepository = userRepository;
        this.validator = validator;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User create(User user) {
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);
        return userRepository.save(user);
    }

    @Override
    public User update(String user_id, User request) {
        Set<ConstraintViolation<User>> violations = validator.validate(request);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);
        return userRepository.findById(user_id).map(user ->
                userRepository.save(user.withName(request.getName())
                        .withSurname(request.getSurname())
                        .withEmail(request.getEmail())
                        .withPassword(request.getPassword())
                        .withRuc(request.getRuc())))
                .orElseThrow(()->new ResourceNotFoundException(ENTITY, user_id));
    }

    @Override
    public ResponseEntity<?> delete(String user_id) {
        return userRepository.findById(user_id).map(user -> {
            userRepository.delete(user);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, user_id));
    }
}
