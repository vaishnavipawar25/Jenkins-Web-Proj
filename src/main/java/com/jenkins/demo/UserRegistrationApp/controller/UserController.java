package com.jenkins.demo.UserRegistrationApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.jenkins.demo.UserRegistrationApp.entity.User;
import com.jenkins.demo.UserRegistrationApp.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());  // Add a new User object to the model
        return "register";  // Return the registration page
    }
    @PostMapping("/register")
    public String registerUser(User user) {
        userService.registerUser(user);  // Saves user with username, email, and password
        return "redirect:/login";  // Redirect to login after registration
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password, Model model) {
        if (userService.validateUserCredentials(username, password)) {
            return "redirect:/home";  // Redirect to home if login is successful
        } else {
            // Add error message to the model if the login fails
            model.addAttribute("error", "Invalid username or password");  
            return "login";  // Return to the login page with error message
        }
    }
    @GetMapping("/home")
    public String home() {
        return "home";
    }
}