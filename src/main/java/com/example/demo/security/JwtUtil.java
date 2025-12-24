package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.function.Function;

@Component
public class JwtUtil {

    private String secret = "my-secret-key";
    private long expirationMinutes = 60;

    public JwtUtil() {
    }

    // This constructor is used in tests
    public JwtUtil(String secret, int expirationMinutes) {
        this.secret = secret;
        this.expirationMinutes = expirationMinutes;
    }

    public String generateToken(String email, Long userId) {
        long now = System.currentTimeMillis();
        Date issued = new Date(now);
        Date expiry = new Date(now + expirationMinutes * 60 * 1000);

        return Jwts.builder()
                .claim("email", email)
                .claim("userId", userId)
                .setIssuedAt(issued)
                .setExpiration(expiry)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Claims claims = getAllClaims(token);
            return claims.getExpiration().after(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    public String extractEmail(String token) {
        return getClaim(token, claims -> claims.get("email", String.class));
    }

    public Long extractUserId(String token) {
        return getClaim(token, claims -> claims.get("userId", Long.class));
    }

    private Claims getAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    private <T> T getClaim(String token, Function<Claims, T> resolver) {
        Claims claims = getAllClaims(token);
        return resolver.apply(claims);
    }
}
