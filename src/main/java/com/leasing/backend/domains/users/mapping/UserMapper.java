package com.leasing.backend.domains.users.mapping;

import com.leasing.backend.shared.mapping.EnhancedModelMapper;
import com.leasing.backend.domains.users.domain.entities.User;
import com.leasing.backend.domains.users.resource.UserRequestResource;
import com.leasing.backend.domains.users.resource.UserResource;
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

    public User toModel(UserResource resource) {
        mapper.getConfiguration().setAmbiguityIgnored(true);
<<<<<<< HEAD
        return mapper.map(resource, User.class);
    }
    public User toModelE(UserRequestResource resource) {
        mapper.getConfiguration().setAmbiguityIgnored(true);
=======
>>>>>>> 09f2fd92806be7df8c5ef6720bf9a57fb76eccfd
        return mapper.map(resource, User.class);
    }

    public User toModelE(UserRequestResource resource) {
        mapper.getConfiguration().setAmbiguityIgnored(true);
        return mapper.map(resource, User.class);
    }

}
