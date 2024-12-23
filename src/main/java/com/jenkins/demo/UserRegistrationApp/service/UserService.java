package com.jenkins.demo.UserRegistrationApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jenkins.demo.UserRegistrationApp.entity.User;
import com.jenkins.demo.UserRegistrationApp.repo.UserRepo;

@Service
public class UserService {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserRepo userRepository;

    // Register a user without encoding password
    public void registerUser(User user) {
    	user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public boolean validateUserCredentials(String username, String password) {
        User user = userRepository.findByUsername(username);  // Get user by username
        if (user != null) {
            return passwordEncoder.matches(password, user.getPassword());  // Compare the encrypted password
        }
        return false;  // Return false if no user is found
    }

}