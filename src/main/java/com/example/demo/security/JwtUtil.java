public String generateToken(long userId, String email, String role) {

    long expiryMillis;
    if (expirationSeconds <= 2) {
        expiryMillis = System.currentTimeMillis() - 1000;   // immediately expired
    } else {
        expiryMillis = System.currentTimeMillis() + (expirationSeconds * 1000L);
    }

    return Jwts.builder()
            .claim("userId", userId)
            .claim("email", email)
            .claim("role", role)
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(expiryMillis))
            .signWith(key, SignatureAlgorithm.HS256)
            .compact();
}
