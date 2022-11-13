package com.leasing.backend.users.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestResource {
    private String name;
    private String surname;
    private String email;
    private String password;
    private String ruc;
}
