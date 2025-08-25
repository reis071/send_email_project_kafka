package org.example.userservice.application.services.user;

import org.example.userservice.adapters.outbound.repositories.user.UserImpl;
import org.example.userservice.application.dtos.user.UserDTORequest;
import org.example.userservice.application.services.kafka.KafkaProducerService;
import org.example.userservice.application.useCases.user.UserUseCases;
import org.example.userservice.domain.user.UserDomain;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserUseCases {


    private final UserImpl userImpl;
    private final KafkaProducerService kafkaProducerService;

    public UserService(UserImpl userImpl, KafkaProducerService kafkaProducerService) {
        this.userImpl = userImpl;
        this.kafkaProducerService = kafkaProducerService;
    }

    @Override
    public UserDomain registerUser(UserDTORequest userDTORequest) {

        UserDomain userDomain = userImpl.save(new UserDomain(userDTORequest.name(), userDTORequest.email()));

        String message = String.format(
                "{\"name\": \"%s\", \"email\": \"%s\"}",
                userDomain.getName(),
                userDomain.getEmail());

        kafkaProducerService.sendUserCreatedMessage(message);

        return userDomain;
    }
}
