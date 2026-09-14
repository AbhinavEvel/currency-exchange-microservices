package com.currency.userservice.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.micrometer.common.lang.NonNull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component
public class JwtAuthFilter extends OncePerRequestFilter {
	
	private final JwtUtil jwtutil;
	
	public JwtAuthFilter(JwtUtil jwtutil) {
		this.jwtutil = jwtutil;
	}

	@Override
	protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain)
			throws ServletException, IOException {
			String authHeader = request.getHeader("Authorization");
			
			if(authHeader!=null && authHeader.startsWith("Bearer")) {
				String token  = authHeader.substring(7);
				
				if(jwtutil.isTokenValid(token)) {
					String username = jwtutil.extractUsername(token);
					String role = jwtutil.extractRole(token);
					
					List<SimpleGrantedAuthority> authorities = new ArrayList<>(List.of(new SimpleGrantedAuthority("ROLE_" + role)));
					
					UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username,null,authorities);
					
					SecurityContextHolder.getContext().setAuthentication(authToken);
				}
			}
			
			filterChain.doFilter(request, response);
		
		
	}
	
	

}
