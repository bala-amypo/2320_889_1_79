package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private static final String DEFAULT_SECRET = "ThisIsASecretKeyForJwtDemoProject12345";
    private static final long DEFAULT_EXPIRATION = 1000 * 60 * 60; // 1 hour

    private final Key key;
    private final long expiry;

    // REQUIRED NO-ARG CONSTRUCTOR
    public JwtUtil() {
        this.key = Keys.hmacShaKeyFor(DEFAULT_SECRET.getBytes());
        this.expiry = DEFAULT_EXPIRATION;
    }

    // REQUIRED BY TEST (String,int constructor)
    public JwtUtil(String secret, int expiryInSeconds) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
        this.expiry = expiryInSeconds * 1000L;
    }

    // REQUIRED SIGNATURE BY TEST (username, userId)
    public String generateToken(String username, Long userId) {
        return Jwts.builder()
                .setSubject(username)
                .claim("userId", userId)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiry))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // REQUIRED SIGNATURE BY TEST (userId, username, role)
    public String generateToken(long userId, String username, String role) {
        return Jwts.builder()
                .setSubject(username)
                .claim("userId", userId)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiry))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // TEST CALLS getBody() → MUST RETURN Jws<Claims>
    public Jws<Claims> validateToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
    }

    public String extractUsername(String token) {
        return validateToken(token).getBody().getSubject();
    }

    public Long extractUserId(String token) {
        return validateToken(token).getBody().get("userId", Long.class);
    }

    public String extractRole(String token) {
        return validateToken(token).getBody().get("role", String.class);
    }
}
