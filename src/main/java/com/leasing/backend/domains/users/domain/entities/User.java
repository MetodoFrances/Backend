package com.leasing.backend.domains.users.domain.entities;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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
    private String user_id;

    @Column(name = "name", length = 40, nullable = false)
    private String name;

    @Column(name = "surname", length = 40, nullable = false)
    private String surname;

    @Column(name = "email", length = 40, nullable = false)
    private String email;

    @Column(name = "password", length = 20, nullable = false)
    private String password;

    @Column(name = "ruc",length = 11, nullable = false)
    private String ruc;

}
