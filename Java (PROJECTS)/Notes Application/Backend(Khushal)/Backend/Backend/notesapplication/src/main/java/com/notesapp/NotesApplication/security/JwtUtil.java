package com.notesapp.NotesApplication.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Base64;

@Component
public class JwtUtil {

    private String secret = "f4e5404b57fa78b39e4207b986922e8323a2b78c98713bb0997aaf44c321cdab3e1e4344f4f57d84778d381c0fd27b87";
    private SecretKey key;

    private final long expirationMillis = 24 * 60 * 60 * 1000; // 24 hours

    @PostConstruct
    public void init() {
        byte[] keyBytes = Decoders.BASE64.decode(this.secret);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    // Generate token with username
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMillis))
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }

    // Validate token
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException ex) {
            return false;
        }
    }

    // Extract username from token
    public String extractUsername(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }
}
