package com.currency.exchangeservices.service;

import org.springframework.stereotype.Service;

import com.currency.exchangeservices.entity.ExchangeRate;
import com.currency.exchangeservices.repository.ExchangeRateRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExchangeRateService {
	private final ExchangeRateRepository exchangeRateRepo;
	
	public ExchangeRate getRate(String from, String to) {
		return exchangeRateRepo.findByFromCurrencyAndToCurrency(from, to)
				.orElseThrow(()->new RuntimeException("Exchange rate is not found for"+ from + "to "+to));
		
	}
	
	public ExchangeRate addRate(ExchangeRate exchangerate) {
		return exchangeRateRepo.save(exchangerate);
	}

}
