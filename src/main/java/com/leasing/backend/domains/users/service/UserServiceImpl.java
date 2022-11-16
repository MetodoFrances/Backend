package com.leasing.backend.domains.users.service;

<<<<<<< HEAD
import com.leasing.backend.domains.users.domain.entities.Rol;
import com.leasing.backend.domains.users.domain.entities.User;
import com.leasing.backend.domains.users.domain.persistence.UserRepository;
import com.leasing.backend.domains.users.domain.service.UserService;
import com.leasing.backend.domains.users.resource.UserResource;
import com.leasing.backend.shared.exception.ResourceNotFoundException;
import com.leasing.backend.shared.exception.ResourceValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
=======
import com.leasing.backend.shared.exception.ResourceNotFoundException;
import com.leasing.backend.shared.exception.ResourceValidationException;
import com.leasing.backend.domains.users.domain.entities.User;
import com.leasing.backend.domains.users.domain.persistence.UserRepository;
import com.leasing.backend.domains.users.domain.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
>>>>>>> 09f2fd92806be7df8c5ef6720bf9a57fb76eccfd
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
<<<<<<< HEAD
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
=======
import java.util.List;
import java.util.Set;
>>>>>>> 09f2fd92806be7df8c5ef6720bf9a57fb76eccfd

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private static final String ENTITY = "users";

    @Autowired
    private final UserRepository userRepository;

<<<<<<< HEAD
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

=======
>>>>>>> 09f2fd92806be7df8c5ef6720bf9a57fb76eccfd
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
<<<<<<< HEAD
    public User create(UserResource userResource) {
        User usuario = new User(userResource.getName(),
                userResource.getSurname(),userResource.getEmail(),
                passwordEncoder.encode(userResource.getPassword()), userResource.getRuc(), Arrays.asList(new Rol("ROLE_USER")));
        return userRepository.save(usuario);
    }

    @Override
    public User update(Long user_id, User request) {
=======
    public User create(User user) {
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);
        return userRepository.save(user);
    }

    @Override
    public User update(String user_id, User request) {
>>>>>>> 09f2fd92806be7df8c5ef6720bf9a57fb76eccfd
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
<<<<<<< HEAD
    public ResponseEntity<?> delete(Long user_id) {
=======
    public ResponseEntity<?> delete(String user_id) {
>>>>>>> 09f2fd92806be7df8c5ef6720bf9a57fb76eccfd
        return userRepository.findById(user_id).map(user -> {
            userRepository.delete(user);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, user_id));
    }
<<<<<<< HEAD

    private Collection<? extends GrantedAuthority> mapAutorityRoles(Collection<Rol> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if(user == null) {
            throw new UsernameNotFoundException("Usuario o password inválidos");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(), mapAutorityRoles(user.getRol()));
    }
=======
>>>>>>> 09f2fd92806be7df8c5ef6720bf9a57fb76eccfd
}
