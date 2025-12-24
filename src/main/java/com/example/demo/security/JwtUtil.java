package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtUtil {

    private final Key key;
    private final int expirationMinutes;

    // Required by tests
    public JwtUtil(String secret, int expirationMinutes) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
        this.expirationMinutes = expirationMinutes;
    }

    // Also required (default constructor)
    public JwtUtil() {
        this.key = Keys.hmacShaKeyFor("defaultsecretdefaultsecretdefault12".getBytes());
        this.expirationMinutes = 60;
    }

    // Tests expect: generateToken(long userId, String email, String role)
    public String generateToken(long userId, String email, String role) {

        return Jwts.builder()
                .claim("userId", userId)
                .claim("email", email)
                .claim("role", role)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + (expirationMinutes * 60 * 1000L)))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // VERY IMPORTANT — Tests call .getBody()
    // and expect exceptions for invalid / expired tokens
    public Jws<Claims> validateToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
    }
}
