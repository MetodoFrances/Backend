package com.leasing.backend.users.mapping;

import com.leasing.backend.shared.mapping.EnhancedModelMapper;
import com.leasing.backend.users.domain.entities.User;
import com.leasing.backend.users.resource.UserRequestResource;
import com.leasing.backend.users.resource.UserResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class UserMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public UserResource toResource(User model) {
        return mapper.map(model, UserResource.class);
    }

    public Page<UserResource> modelListPage(List<User> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, UserResource.class), pageable, modelList.size());
    }

    public User toModel(UserRequestResource resource) {
        return mapper.map(resource, User.class);
    }
}
