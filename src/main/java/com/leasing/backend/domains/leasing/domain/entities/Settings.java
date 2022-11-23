package com.leasing.backend.domains.leasing.domain.entities;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
@Table(name = "settings")
public class Settings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String languageName;
    private String country;

    @OneToOne
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    @JsonDeserialize
    private User user;

}
