package com.project.StudentMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.StudentMS.dto.LoginRequest;
import com.project.StudentMS.model.User;
import com.project.StudentMS.service.UserService;


@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.registerUser(user);
    }
    @PostMapping("/login")
public String login(
        @RequestBody LoginRequest request){

    return userService.login(
            request.getUsername(),
            request.getPassword()
    );
}
}
