package com.leasing.backend.domains.leasing.domain.entities;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;


@Slf4j
@Getter
@Setter
@With
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "ruc")
    private String ruc;

    public User(Long id) {
        this.id = id;
    }
}
