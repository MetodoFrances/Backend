package com.leasing.backend.domains.leasing.resources;

import com.leasing.backend.domains.leasing.domain.entities.User;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class SaveSettingsResource {
    private String languageName;
    private String country;
    private User userId;
}
