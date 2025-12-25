package com.example.demo.security;

import io.jsonwebtoken.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class JwtUtil {

    private String SECRET_KEY = "default_secret_key";
    private long EXPIRATION = 1000 * 60 * 60;

    // ================= CONSTRUCTORS =================

    // Required by your tests
    public JwtUtil() {
    }

    // Required by your tests (secret, expirySeconds)
    public JwtUtil(String secret, int expirySeconds) {
        this.SECRET_KEY = secret;
        this.EXPIRATION = expirySeconds * 1000L;
    }

    // ================= TOKEN GENERATION =================

    // Used in main project
    public String generateToken(String username, Long userId) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", userId);
        return createToken(claims, username);
    }

    // Used by tests → (long userId, username, role)
    public String generateToken(long userId, String username, String role) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", userId);
        claims.put("role", role);
        return createToken(claims, username);
    }

    private String createToken(Map<String, Object> claims, String subject) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + EXPIRATION);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    // ================= EXTRACT =================
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private <T> T extractClaim(String token, Function<Claims, T> resolver) {
        return resolver.apply(extractAllClaims(token));
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

    private boolean isExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // ================= VALIDATION =================

    // Tests expect Boolean validate
    public Boolean validateToken(String token) {
        try {
            return !isExpired(token);
        } catch (Exception e) {
            return false;
        }
    }

    // Tests expect validate().getBody()
    public Jws<Claims> validateAndReturnClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token);
    }

    // Tests call jwtUtil.validateToken(token).getBody()
    // So we make a wrapper returning same as above
    public Jws<Claims> validateTokenAndReturn(String token) {
        return validateAndReturnClaims(token);
    }

    // Overload used earlier
    public Boolean validateToken(String token, String username) {
        try {
            return extractUsername(token).equals(username) && !isExpired(token);
        } catch (Exception e) {
            return false;
        }
    }
}
