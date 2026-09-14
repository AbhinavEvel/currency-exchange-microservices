package com.currency.userservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.currency.userservice.dto.AuthResponse;
import com.currency.userservice.dto.LoginRequest;
import com.currency.userservice.dto.RegesterRequest;
import com.currency.userservice.services.userservices;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
	private final userservices userserv;
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@Valid @RequestBody RegesterRequest request){
		String message  = userserv.register(request);
		return ResponseEntity.ok(message);
	}
	
	@PostMapping("/login")
	public ResponseEntity<AuthResponse> login(@RequestBody  LoginRequest request){
		AuthResponse response = userserv.login(request);
		return ResponseEntity.ok(response);
		
	}

}
