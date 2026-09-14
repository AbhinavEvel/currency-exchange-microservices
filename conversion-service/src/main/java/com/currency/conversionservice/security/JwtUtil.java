package com.currency.conversionservice.security;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;



@Component
public class JwtUtil {
	
	@Value("${jwt.secret}")
	private String secret;
	

	private SecretKey getSigningKey() {
		return Keys.hmacShaKeyFor(secret.getBytes());
	}
	
	private Claims getClaims(String token) {
		return Jwts.parserBuilder().setSigningKey(getSigningKey()).build()
				.parseClaimsJws(token).getBody();
		
	}
	public String extractUsername(String token) {
		return getClaims(token)
				.getSubject();	
		}
	public boolean isTokenValid(String token) {
		try {
			getClaims(token);
			return true;
		}catch(JwtException | IllegalArgumentException e) {
			 System.out.println("JWT Error Type: " + e.getClass().getName());
		        System.out.println("JWT Error Message: " + e.getMessage());
			return false;
		}
	}
	
}
