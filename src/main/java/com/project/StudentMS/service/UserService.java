package com.project.StudentMS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.StudentMS.model.User;
import com.project.StudentMS.repository.UserRepository;

@Service
public class UserService {

    // @Autowired
    // private UserRepository userRepository;

    // public User registerUser(User user) {
    //     return userRepository.save(user);
    // }

     @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
     @Autowired
private JwtService jwtService;
    //register part

    public User registerUser(User user) {

        user.setPassword(
                passwordEncoder.encode(user.getPassword())
        );

        return userRepository.save(user);

    }


    // login part 
    public String login(String username,
                    String password) {

    User user = userRepository
            .findByUsername(username)
            .orElseThrow(() ->
                    new RuntimeException(
                            "User Not Found"));

    boolean matched =
            passwordEncoder.matches(
                    password,
                    user.getPassword());

    if(matched){
     return jwtService.generateToken(
        user.getUsername()
);
    }

    return "Invalid Credentials";
}
}