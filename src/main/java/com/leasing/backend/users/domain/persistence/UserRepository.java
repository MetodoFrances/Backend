package com.leasing.backend.users.domain.persistence;

import com.leasing.backend.users.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    @Override
    List<User> findAll();
    @Query("from User u where u.name like %:name%")
    List<User> findByName(@Param("name") String name);
    User findAllById(String user_id);
}
