package com.currency.userservice.services;

import org.springframework.stereotype.Service;

import com.currency.userservice.dto.AuthResponse;
import com.currency.userservice.dto.LoginRequest;
import com.currency.userservice.dto.RegesterRequest;
import com.currency.userservice.entity.Users;
import com.currency.userservice.repository.userRepository;
import com.currency.userservice.security.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class userservices {
	
	private final userRepository usersrepo;
	private final PasswordEncoder passwordEncoder;
	private final JwtUtil jwtUtil;
	
	public String register(RegesterRequest request) {
		if(usersrepo.existsByUsername(request.getUsername())) {
			throw new RuntimeException("Username is already taken");
		}
		if(usersrepo.existsByEmail(request.getEmail())) {
			throw new RuntimeException("Email is already register");
		}
		
		Users user = new Users();
		user.setUsername(request.getUsername());
		user.setEmail(request.getEmail());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		user.setRole("USER");
		
		usersrepo.save(user);
		return "Users us registered Successfully";
	}
		
		public AuthResponse login(LoginRequest request) {
			Users user = usersrepo.findByUsername(request.getUsername())
					.orElseThrow(()->new RuntimeException("Invalid username"));
			if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
	            throw new RuntimeException("Invalid username or password");
	        }

	        String token = jwtUtil.generateToken(user.getUsername(), user.getRole());
	        return new AuthResponse(token, user.getUsername(), user.getRole());
			
		}
	}


