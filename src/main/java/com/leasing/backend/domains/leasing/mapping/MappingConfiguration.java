package com.leasing.backend.domains.leasing.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("LoanMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public LoanMapper loanMapper() { return new LoanMapper(); }
    @Bean
    public UserMapper userMapper() { return new UserMapper(); }
}
