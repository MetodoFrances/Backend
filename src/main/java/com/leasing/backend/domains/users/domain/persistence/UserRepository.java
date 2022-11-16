package com.leasing.backend.domains.users.domain.persistence;

import com.leasing.backend.domains.users.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
<<<<<<< HEAD
public interface UserRepository extends JpaRepository<User, Long> {
    @Override
    List<User> findAll();

    public User findByEmail(String email);
=======
public interface UserRepository extends JpaRepository<User, String> {
    @Override
    List<User> findAll();
>>>>>>> 09f2fd92806be7df8c5ef6720bf9a57fb76eccfd
}
