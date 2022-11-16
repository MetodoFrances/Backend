package com.leasing.backend.domains.users.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("UserMappingConfiguration")
public class MappingConfiguration{
    @Bean
    public UserMapper userMapper() {
        return new UserMapper();
    }
}
