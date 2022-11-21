package com.leasing.backend.shared.mapping;


import com.leasing.backend.shared.mapping.EnhancedModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("enhancedModelMapperConfiguration")
public class MappingConfiguration {

    @Bean
    public EnhancedModelMapper modelMapper(){

        return new EnhancedModelMapper();
    }

}