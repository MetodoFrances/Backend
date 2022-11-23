package com.leasing.backend.domains.leasing.mapping;

import com.leasing.backend.domains.leasing.domain.entities.Loan;
import com.leasing.backend.domains.leasing.domain.entities.User;
import com.leasing.backend.domains.leasing.resources.LoanResource;
import com.leasing.backend.domains.leasing.resources.RegisterUserResource;
import com.leasing.backend.domains.leasing.resources.SaveLoanResource;
import com.leasing.backend.domains.leasing.resources.UserResource;
import com.leasing.backend.shared.mapping.EnhancedModelMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

@Slf4j
public class UserMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public UserResource toResource(User model) {
        return mapper.map(model,UserResource.class);
    }

    public Page<UserResource> modelListPage(List<User> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList,UserResource.class), pageable, modelList.size());
    }

    public User toModel(RegisterUserResource resource) {
        mapper.getConfiguration().setAmbiguityIgnored(true);
        return mapper.map(resource, User.class);
    }
}
