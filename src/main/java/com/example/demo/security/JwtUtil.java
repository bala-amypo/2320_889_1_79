package com.example.demo.security;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    private String secret;
    private long expirationMs;

    // ========= REQUIRED BY TESTS =========
    public JwtUtil() {
        this.secret = "mysecretkey123456";
        this.expirationMs = 3600000;
    }

    // ========= ALSO REQUIRED BY TESTS =========
    public JwtUtil(String secret, int expirationSeconds) {
        this.secret = secret;
        this.expirationMs = expirationSeconds * 1000L;
    }

    // ========= MATCH EXACT TEST SIGNATURE =========
    public String generateToken(long userId, String username, String role) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", userId);
        claims.put("role", role);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    // ========= THIS ONE ALSO NEEDED BY TEST =========
    public Jws<Claims> validateToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token);
    }

    // ========= USED BY APP =========
    public boolean validateToken(String token, String username) {
        try {
            return extractUsername(token).equals(username) && !isExpired(token);
        } catch (Exception e) {
            return false;
        }
    }

    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    private boolean isExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }
}
