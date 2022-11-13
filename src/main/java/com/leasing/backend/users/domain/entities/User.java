package com.leasing.backend.users.domain.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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

    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 2, max = 40, message = "Name must have between 2 and 64 characters")
    @Column(name = "name", length = 40, nullable = false)
    private String name;

    @NotEmpty(message = "Surname cannot be empty")
    @Size(min = 2, max = 40, message = "Surname must have between 2 and 64 characters")
    @Column(name = "surname", length = 40, nullable = false)
    private String surname;

    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Invalid email.")
    @Column(name = "email", length = 40, nullable = false)
    private String email;

    @NotEmpty(message = "Password cannot be empty")
    @Size(min = 8, max = 20, message = "Password must have between 8 and 20 characters")
    @Column(name = "password", length = 20, nullable = false)
    private String password;

    @NotEmpty(message = "RUC cannot be empty")
    @Size(min = 11, max = 11, message = "RUC must have 11 characters")
    @Column(name = "ruc",length = 11, nullable = false)
    private String ruc;

}
