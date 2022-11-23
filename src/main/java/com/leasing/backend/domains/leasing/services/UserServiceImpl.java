package com.leasing.backend.domains.leasing.services;

import com.leasing.backend.domains.leasing.domain.entities.User;
import com.leasing.backend.domains.leasing.domain.persistance.UserRepository;
import com.leasing.backend.domains.leasing.domain.service.UserService;
import com.leasing.backend.domains.leasing.resources.LoginUserResource;
import com.leasing.backend.shared.exception.ResourceNotFoundException;
import com.leasing.backend.shared.exception.ResourceValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private static final String ENTITY = "users";

    @Autowired
    private final UserRepository userRepository;

    private final Validator validator;

    public UserServiceImpl(UserRepository loanRepository, Validator validator) {
        this.userRepository = loanRepository;
        this.validator = validator;
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User registerUser(User user) {
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);
        return userRepository.save(user);
    }

    @Override
    public User loginUser(LoginUserResource user) {
        User result = userRepository.findByEmailAndPassword(user.getEmail(),user.getPassword());
        if(result == null)
            throw new ResourceNotFoundException("Email or password doesn't match");
        return result;
    }
}
