package com.leasing.backend.domains.users.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UserResource {
    private String user_id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String ruc;
}
