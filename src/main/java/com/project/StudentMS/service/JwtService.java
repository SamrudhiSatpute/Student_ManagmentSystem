package com.project.StudentMS.service;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
    private static final String SECRET_KEY =
        "mysecretkeymysecretkeymysecretkeymysecretkey";

     private Key getSignKey() {

    return Keys.hmacShaKeyFor(
            SECRET_KEY.getBytes()
    );
} 

public String generateToken(String username) {

    return Jwts.builder()
            .subject(username)
            .issuedAt(new Date())
            .expiration(
                    new Date(
                            System.currentTimeMillis()
                                    + 1000 * 60 * 60
                    )
            )
            .signWith(
                    getSignKey()
            )
            .compact();
}

public String extractUsername(String token) {

    return Jwts
            .parser()
            .verifyWith((javax.crypto.SecretKey)getSignKey())
            .build()
            .parseSignedClaims(token)
            .getPayload()
            .getSubject();
}
public boolean validateToken(String token,
                             String username) {

    String extractedUsername =
            extractUsername(token);

    return extractedUsername
            .equals(username);
}
}
