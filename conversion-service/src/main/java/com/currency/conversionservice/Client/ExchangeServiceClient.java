package com.currency.conversionservice.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.currency.conversionservice.dto.ExchangeRateResponse;

@FeignClient(name = "exchange-service")
public interface ExchangeServiceClient {
	
	@GetMapping("/api/exchange/rate/{from}/{to}")
	ExchangeRateResponse getRate(@PathVariable("from") String from,@PathVariable("to") String to);

}
