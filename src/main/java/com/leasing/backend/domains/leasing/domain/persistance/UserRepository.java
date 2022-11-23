package com.leasing.backend.domains.leasing.domain.persistance;

import com.leasing.backend.domains.leasing.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    @Override
    List<User> findAll();

    User findByEmailAndPassword(String email, String password);
}
