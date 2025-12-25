package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtil {

    private static final String DEFAULT_SECRET = "transport_secret_key";
    private static final long DEFAULT_EXPIRATION = 1000 * 60 * 60; // 1 hour

    private String secret = DEFAULT_SECRET;
    private long expiration = DEFAULT_EXPIRATION;

    // ******** Required by TEST ********
    public JwtUtil() {}

    // ******** Required by TEST ********
    public JwtUtil(String secret, int expirationInSeconds) {
        this.secret = secret;
        this.expiration = expirationInSeconds * 1000L;
    }

    // ===== TEST EXPECTS THIS METHOD =====
    public String generateToken(String email, Long userId) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", userId);
        return createToken(claims, email);
    }

    // ===== TEST EXPECTS THIS METHOD =====
    public String generateToken(long userId, String email, String role) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", userId);
        claims.put("role", role);
        return createToken(claims, email);
    }

    // ===== TEST EXPECTS THIS METHOD =====
    public boolean validateToken(String token) {
        try {
            return !isTokenExpired(token);
        } catch (Exception e) {
            return false;
        }
    }

    // ===== TEST EXPECTS THIS METHOD =====
    public boolean validateToken(String token, String email) {
        String username = extractUsername(token);
        return username != null && username.equals(email) && !isTokenExpired(token);
    }

    // ===== FILTER & PROJECT NEED THESE =====
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Long extractUserId(String token) {
        Object value = extractAllClaims(token).get("userId");
        if (value instanceof Integer)
            return ((Integer) value).longValue();
        return value == null ? null : (Long) value;
    }

    public String extractRole(String token) {
        Object role = extractAllClaims(token).get("role");
        return role == null ? null : role.toString();
    }

    // ===== Core Helpers =====
    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    private <T> T extractClaim(String token, Function<Claims, T> resolver) {
        return resolver.apply(extractAllClaims(token));
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    private boolean isTokenExpired(String token) {
        Date expirationDate = extractClaim(token, Claims::getExpiration);
        return expirationDate.before(new Date());
    }
}
