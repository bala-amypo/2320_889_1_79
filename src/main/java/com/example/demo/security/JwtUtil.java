package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtUtil {

    private final Key key;
    private final int expirationSeconds;

    public JwtUtil(String secret, int expirationSeconds) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
        this.expirationSeconds = expirationSeconds;
    }

    public JwtUtil() {
        this.key = Keys.hmacShaKeyFor("defaultsecretdefaultsecretdefault12".getBytes());
        this.expirationSeconds = 60;
    }

    public String generateToken(long userId, String email, String role) {

        long expiryMillis;
        if (expirationSeconds <= 0) {
            expiryMillis = System.currentTimeMillis() - 1000; // expired immediately
        } else {
            expiryMillis = System.currentTimeMillis() + (expirationSeconds * 1000L); // seconds not minutes
        }

        return Jwts.builder()
                .claim("userId", userId)
                .claim("email", email)
                .claim("role", role)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(expiryMillis))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public Jws<Claims> validateToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
    }
}
