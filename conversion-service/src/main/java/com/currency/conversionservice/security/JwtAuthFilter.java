package com.currency.conversionservice.security;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.micrometer.common.lang.NonNull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

@Component
public class JwtAuthFilter extends OncePerRequestFilter  {
	private final JwtUtil jwtUtil;
	
	public JwtAuthFilter(JwtUtil jwtUtil) {
		this.jwtUtil = jwtUtil;
	}

	@Override
	protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,@NonNull FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String authHeader = request.getHeader("Authorization");
		
		if(authHeader!=null && authHeader.startsWith("Bearer")) {
			String token  = authHeader.substring(7);
			System.out.println("Received Token: " + token);
		    System.out.println("Is Valid: " + jwtUtil.isTokenValid(token));
			
			if(jwtUtil.isTokenValid(token)) {
				String username = jwtUtil.extractUsername(token);
				UsernamePasswordAuthenticationToken  authToken = new UsernamePasswordAuthenticationToken (username,null,null);
				SecurityContextHolder.getContext().setAuthentication(authToken);
				
			}
		}
		filterChain.doFilter(request, response);
	}
	
	

}
