package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
import java.util.Optional;

public class JwtUtil {

    private final Key key;
    private final int expirationMinutes;

    // ===== Test expects this constructor =====
    public JwtUtil(String secret, int expirationMinutes) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
        this.expirationMinutes = expirationMinutes;
    }

    // ===== Test also creates default constructor =====
    public JwtUtil() {
        this.key = Keys.hmacShaKeyFor("defaultsecretdefaultsecretdefault12".getBytes());
        this.expirationMinutes = 60;
    }

    // ===== Test expects THIS method signature =====
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

    // ===== Test expects validateToken().isPresent() =====
    public Optional<Claims> validateToken(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            return Optional.of(claims);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    // Helper claim extractors (used in tests)
    public Optional<String> getEmail(String token) {
        return validateToken(token).map(c -> c.get("email", String.class));
    }

    public Optional<String> getRole(String token) {
        return validateToken(token).map(c -> c.get("role", String.class));
    }

    public Optional<Long> getUserId(String token) {
        return validateToken(token).map(c -> c.get("userId", Long.class));
    }
}
