package com.leasing.backend.domains.leasing.resources;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UserResource {
    private Long id;
    private String name;
    private String surName;
    private String email;
    private String password;
    private String ruc;
}
