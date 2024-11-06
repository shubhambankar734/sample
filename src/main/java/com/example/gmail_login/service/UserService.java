package com.example.gmail_login.service;


import com.example.gmail_login.model.User;
import com.example.gmail_login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User authenticateUser(String username, String password) {
        return userRepository.findByNameAndPassword(username, password);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
    }

    public User findByUsername(String username) {
        return userRepository.findByName(username);
    }
}

