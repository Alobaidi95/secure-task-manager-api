package com.osamah.taskmanager.service;

import com.osamah.taskmanager.model.User;
public interface UserService {

    User registerUser(String username, String email, String rawPassword);
}
