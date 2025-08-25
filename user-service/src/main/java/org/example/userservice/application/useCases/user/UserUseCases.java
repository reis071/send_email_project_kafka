package org.example.userservice.application.useCases.user;

import org.example.userservice.application.dtos.user.UserDTORequest;
import org.example.userservice.domain.user.UserDomain;

public interface UserUseCases {

    UserDomain  registerUser(UserDTORequest userDTORequest);

}
