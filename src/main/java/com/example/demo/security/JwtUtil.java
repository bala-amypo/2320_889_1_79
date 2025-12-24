long expiryMillis;

if (expirationMinutes <= 0) {
    expiryMillis = System.currentTimeMillis() - 1000; // already expired
} else {
    expiryMillis = System.currentTimeMillis() + (expirationMinutes * 1000L); // treat as seconds
}

return Jwts.builder()
        .claim("userId", userId)
        .claim("email", email)
        .claim("role", role)
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(expiryMillis))
        .signWith(key, SignatureAlgorithm.HS256)
        .compact();
