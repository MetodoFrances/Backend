package com.leasing.backend.domains.leasing.resources;
import com.leasing.backend.domains.leasing.domain.entities.User;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class SettingsResource {
    private Long id;
    private String languageName;
    private String country;
    private Long userId;
}
