package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private String SECRET = "THIS_IS_A_DEMO_SECRET_FOR_TESTING_ONLY_123456";
    private long EXPIRATION = 1000 * 60 * 60; // 1 hour default

    public JwtUtil() {
    }

    // REQUIRED BY TESTS
    public JwtUtil(String secret, int expiryMinutes) {
        this.SECRET = secret;
        this.EXPIRATION = expiryMinutes * 60_000L;
    }

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }

    // REQUIRED SIGNATURE IN TESTS
    public String generateToken(long userId, String email, String role) {
        return Jwts.builder()
                .setSubject(email)
                .claim("userId", userId)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // Used by application flow
    public String generateToken(String email, Long userId) {
        return Jwts.builder()
                .setSubject(email)
                .claim("userId", userId)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // MUST RETURN Jws<Claims> because tests call getBody()
    public Jws<Claims> validateToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token);
    }

    public String extractEmail(String token) {
        return validateToken(token).getBody().getSubject();
    }

    public Long extractUserId(String token) {
        Object id = validateToken(token).getBody().get("userId");
        return id == null ? null : Long.valueOf(id.toString());
    }

    public String extractRole(String token) {
        Object role = validateToken(token).getBody().get("role");
        return role == null ? null : role.toString();
    }
}
