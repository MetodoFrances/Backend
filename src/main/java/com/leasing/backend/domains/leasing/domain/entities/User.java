package com.leasing.backend.domains.leasing.domain.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;
    private String surName;
    private String email;
    private String password;
    private String ruc;

    public User(String name, String surName, String email, String password, String ruc) {
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.password = password;
        this.ruc = ruc;
    }
}
