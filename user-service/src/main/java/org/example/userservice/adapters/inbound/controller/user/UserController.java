package org.example.userservice.adapters.inbound.controller.user;

import org.example.userservice.application.dtos.user.UserDTORequest;
import org.example.userservice.application.services.user.UserService;
import org.example.userservice.domain.user.UserDomain;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserDomain registerUser(@RequestBody UserDTORequest userDTORequest) {
        return userService.registerUser(userDTORequest);
    }

}
