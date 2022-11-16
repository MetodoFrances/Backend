package com.leasing.backend.domains.users.domain.entities;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;

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
    private Long user_id;

    @Column(name = "name", length = 40, nullable = false)
    private String name;

    @Column(name = "surname", length = 40, nullable = false)
    private String surname;

    @Column(name = "email", length = 40, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "ruc",length = 11, nullable = false)
    private String ruc;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "users_id",referencedColumnName = "user_id")
            ,inverseJoinColumns = @JoinColumn(name = "rols_id",referencedColumnName = "rol_id"))
    Collection<Rol> rol;

    public User(String name, String surname, String email, String password, String ruc, Collection<Rol> roles) {
        super();
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.ruc = ruc;
        this.rol = roles;
    }

}
