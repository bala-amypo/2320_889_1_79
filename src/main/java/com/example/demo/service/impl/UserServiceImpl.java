package com.example.demo.service.impl;

import com.example.demo.service.UserService;   // ✅ MUST exist
import org.springframework.stereotype.Service; // ✅ import
import org.springframework.security.crypto.password.PasswordEncoder; // ✅ import

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
}
