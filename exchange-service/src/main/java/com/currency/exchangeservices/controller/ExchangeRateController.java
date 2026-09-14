package com.currency.exchangeservices.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.currency.exchangeservices.entity.ExchangeRate;
import com.currency.exchangeservices.service.ExchangeRateService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/exchange")
@RequiredArgsConstructor
public class ExchangeRateController {
	
	private final ExchangeRateService exchangeRateService;
	
	@GetMapping("/rate/{from}/{to}")
	public ResponseEntity<ExchangeRate> getRate(@PathVariable String from,@PathVariable String to){
		return ResponseEntity.ok(exchangeRateService.getRate(from, to));
		
	}
	
	@PostMapping("/rate")
	public ResponseEntity<ExchangeRate> addRate(@RequestBody ExchangeRate exchangeRate){
		return ResponseEntity.ok(exchangeRateService.addRate(exchangeRate));
		
	}

}
