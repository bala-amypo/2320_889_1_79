package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private static final String SECRET =
            "THIS_IS_SUPER_SECRET_KEY_FOR_TESTING_PURPOSE_123456";
    private static final long EXPIRATION = 1000 * 60 * 5; // 5 mins

    private final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());

    public String generateToken(String email, Long userId) {

        return Jwts.builder()
                .setSubject(email)
                .claim("userId", userId)
                .claim("role", "USER")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public Jws<Claims> validateToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
    }

    public String getEmail(String token) {
        return validateToken(token).getBody().getSubject();
    }
}
