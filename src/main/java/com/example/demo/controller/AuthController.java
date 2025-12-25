package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.security.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    // ----------------- REGISTER -----------------
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {

        if (user.getRole() == null || user.getRole().isBlank()) {
            user.setRole("USER");    // default role
        }

        User saved = userService.register(user);

        String token = jwtUtil.generateToken(
                saved.getEmail(),
                saved.getId(),
                saved.getRole()
        );

        return ResponseEntity.ok(Map.of(
                "message", "User Registered Successfully",
                "token", token
        ));
    }

    // ----------------- LOGIN -----------------
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        String password = request.get("password");

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password)
            );
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401)
                    .body(Map.of("error", "Invalid Credentials"));
        }

        User user = userService.findByEmail(email);

        String token = jwtUtil.generateToken(
                user.getEmail(),
                user.getId(),
                user.getRole()
        );

        return ResponseEntity.ok(Map.of(
                "token", token
        ));
    }
}
