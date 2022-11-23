package com.leasing.backend.domains.leasing.resources;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class LoginUserResource {
    private String email;
    private String password;
}
