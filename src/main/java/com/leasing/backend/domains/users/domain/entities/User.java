package com.leasing.backend.domains.users.domain.entities;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

<<<<<<< HEAD
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;
=======
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
>>>>>>> 09f2fd92806be7df8c5ef6720bf9a57fb76eccfd

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
<<<<<<< HEAD
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
=======
    private String user_id;
>>>>>>> 09f2fd92806be7df8c5ef6720bf9a57fb76eccfd

    @Column(name = "name", length = 40, nullable = false)
    private String name;

    @Column(name = "surname", length = 40, nullable = false)
    private String surname;

    @Column(name = "email", length = 40, nullable = false)
    private String email;

<<<<<<< HEAD
    @Column(name = "password", nullable = false)
=======
    @Column(name = "password", length = 20, nullable = false)
>>>>>>> 09f2fd92806be7df8c5ef6720bf9a57fb76eccfd
    private String password;

    @Column(name = "ruc",length = 11, nullable = false)
    private String ruc;

<<<<<<< HEAD
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

=======
>>>>>>> 09f2fd92806be7df8c5ef6720bf9a57fb76eccfd
}
