package com.leasing.backend.domains.leasing.domain.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@Entity
@Table(name = "settings")
@Data
@NoArgsConstructor
public class Settings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long settingsId;
    private String languageName;
    private String country;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Settings( String languageName, String country) {
        this.languageName = languageName;
        this.country = country;
    }

}
