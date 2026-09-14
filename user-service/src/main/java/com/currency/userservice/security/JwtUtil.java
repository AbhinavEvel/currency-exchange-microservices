package com.currency.userservice.security;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;

@Component
public class JwtUtil {

	@Value("${jwt.secret}")
	private String secret;

	@Value("${jwt.expiration}")
	private long expiration;

	private SecretKey getSigningKey() {
		return Keys.hmacShaKeyFor(secret.getBytes());
	}
	
	 public String generateToken(String username, String role) {
	        return Jwts.builder()
	                .setSubject(username)
	                .claim("role", role)
	                .setIssuedAt(new Date())
	                .setExpiration(new Date(System.currentTimeMillis() + expiration))
	                .signWith(getSigningKey())
	                .compact();
	    }
	private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
	
	public String extractUsername(String token) {
		return getClaims(token).getSubject();
	}
	
	public String extractRole(String token) {
		return getClaims(token).get("role",String.class);
	}
	
	public boolean isTokenValid(String token) {
		try {
			getClaims(token);
			return true;
			
		}catch(JwtException | IllegalArgumentException e){
			return false;
		}
		
	}
}
