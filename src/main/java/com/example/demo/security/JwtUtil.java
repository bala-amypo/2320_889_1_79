package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    private final String SECRET_KEY = "mysecretkey123456";
    private final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hour

    public JwtUtil() {
    }

    // ================= TOKEN GENERATION =================
    public String generateToken(String username, Long userId) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", userId);
        return createToken(claims, username);
    }

    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    // ================= EXTRACTORS =================
    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    public Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

    private Boolean isExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }

    // ================= VALIDATION =================

    // Used by APPLICATION (boolean)
    public Boolean validateToken(String token, String username) {
        try {
            String extractedUser = extractUsername(token);
            return extractedUser.equals(username) && !isExpired(token);
        } catch (Exception e) {
            return false;
        }
    }

    // Used by TESTS (they call validateToken(token).getBody())
    public Jws<Claims> validateToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token);
    }
}
