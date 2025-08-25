package org.example.userservice.adapters.outbound.repositories.user;

import org.example.userservice.adapters.outbound.entities.user.UserModel;
import org.example.userservice.domain.user.UserDomain;
import org.example.userservice.domain.user.UserRepositoryDomain;
import org.springframework.stereotype.Component;

@Component
public class UserImpl implements UserRepositoryDomain {

    private final UserRepositoryJPA repository;

    public UserImpl(UserRepositoryJPA repository) {
        this.repository = repository;
    }

    @Override
    public UserDomain save(UserDomain user) {
        UserModel userModel = repository.save(new UserModel(user));
        user = new UserDomain(userModel.getName(), userModel.getEmail());
        user.setId(userModel.getId());
        return user;
    }
}
