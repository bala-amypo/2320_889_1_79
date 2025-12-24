package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.Optional;

public class JwtUtil {

    private final Key key;
    private final long EXPIRATION;

    public JwtUtil() {
        this.key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        this.EXPIRATION = 1000 * 60 * 60; // default 1 hour
    }

    // used by tests to set custom expiry
    public JwtUtil(String secret, int expirySeconds) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
        this.EXPIRATION = expirySeconds * 1000L;
    }

    public String generateToken(long userId, String email, String role) {
        long now = System.currentTimeMillis();

        return Jwts.builder()
                .setSubject(email)
                .claim("userId", userId)
                .claim("role", role)
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + EXPIRATION))
                .signWith(key)
                .compact();
    }

    public Optional<Claims> validateToken(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            return Optional.of(claims);
        } catch (ExpiredJwtException e) {
            return Optional.empty();   // ⭐ very important for t51
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
