package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // REGISTER
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    // LOGIN (basic example)
    @PostMapping("/login")
    public String login(@RequestParam String email) {

        User user = userService.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return "Login successful for role: " + user.getRole();
    }
}
