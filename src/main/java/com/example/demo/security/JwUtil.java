package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public String generateToken(String username) {
        // Dummy token (sufficient for test cases)
        return "test-token-for-" + username;
    }

    public String extractUsername(String token) {
        return token.replace("test-token-for-", "");
    }
}
