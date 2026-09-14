package com.currency.conversionservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.currency.conversionservice.Client.ExchangeServiceClient;
import com.currency.conversionservice.dto.ConversionResponse;
import com.currency.conversionservice.dto.ExchangeRateResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/convert")
@RequiredArgsConstructor
public class ConversionController {
		private final ExchangeServiceClient exchangeServiceClient;
		
		@GetMapping("{from}/{to}/{amount}")
		public ResponseEntity<ConversionResponse> convert(
				@PathVariable String from,
				@PathVariable String to,
				@PathVariable Double amount){
			ExchangeRateResponse rateresponse = exchangeServiceClient.getRate(from, to);
			Double convertedAmount = amount * rateresponse.getRate();
			ConversionResponse response = new ConversionResponse(
					from , to, rateresponse.getRate(),amount,convertedAmount);
			return ResponseEntity.ok(response);
		}
		
}
