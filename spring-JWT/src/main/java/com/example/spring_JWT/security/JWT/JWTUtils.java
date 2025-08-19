package com.example.spring_JWT.security.JWT;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
// import jakarta.validation.Valid;

@Component
public class JWTUtils {

    // @Value("$(jwt.secret.key)")
    @Value("${jwt.secret.key}")
    private String secretKey;

    @Value("${jwt.expiration.time}")
    private String timeExpiration;

    //generating acces token
    public String generateAccessToken(String username) {
        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(timeExpiration)))
            .signWith(getSignatureKey(), SignatureAlgorithm.HS256)
            .compact();
    }


    //validating access token
    public boolean isTokenValid(String token) {
        try {
            Jwts.parserBuilder()
                .setSigningKey(getSignatureKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
            return true;
        } catch (Exception e) {
            System.err.println("Token invalido, error: ".concat(" " + e.getMessage()));
            return false;
        }
    }


    //geting username of token
    public String getUsernameFromToken(String token) {
        return getClaim(token, Claims::getSubject);
    }

    //getting just one claim
    public <T> T getClaim(String token, Function<Claims, T> claimsTFunction){
        Claims claims = extractAllClaims(token);
        return claimsTFunction.apply(claims);
    }

    //getting all token claims
    public Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
            .setSigningKey(getSignatureKey())
            .build()
            .parseClaimsJws(token)
            .getBody();
    }

    public Key getSignatureKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
