package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    // -------- Register User --------
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user){
        User savedUser = userService.register(user);
        return ResponseEntity.ok(savedUser);
    }

    // -------- Login & Token --------
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User userRequest){

        User user = userService.findByEmail(userRequest.getEmail());

        if(user == null || !user.getPassword().equals(userRequest.getPassword())){
            throw new BadCredentialsException("Invalid username or password");
        }

        // Token expects ONLY username field
        String token = jwtUtil.generateToken(user.getEmail());

        return ResponseEntity.ok(token);
    }
}
