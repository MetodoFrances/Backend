package com.leasing.backend.domains.leasing.domain.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "settings")
@Data
@NoArgsConstructor
public class Settings{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long settingsId;
    private String languageName;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Userb user;

    public Settings( String languageName) {
        this.languageName = languageName;
    }
}
