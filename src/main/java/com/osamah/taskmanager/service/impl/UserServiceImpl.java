package com.osamah.taskmanager.service.impl;

import com.osamah.taskmanager.exception.BadRequestException;
import com.osamah.taskmanager.model.Role;
import com.osamah.taskmanager.model.User;
import com.osamah.taskmanager.repository.UserRepository;
import com.osamah.taskmanager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public User registerUser(String username, String email, String rawPassword) {
        if(userRepository.existsByEmail(email))
        {
            throw new BadRequestException("Email already exists");
        }
        if(userRepository.existsByUsername(username))
        {
            throw new BadRequestException("Username already exists");
        }

        User user = User.builder()
                .username(username)
                .email(email)
                .password(passwordEncoder.encode(rawPassword))
                .role(Role.USER)
                .build();

        return userRepository.save(user);


    }
}
