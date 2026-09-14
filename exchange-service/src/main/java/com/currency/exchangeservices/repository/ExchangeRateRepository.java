package com.currency.exchangeservices.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.currency.exchangeservices.entity.ExchangeRate;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate,Long> {
	Optional<ExchangeRate> findByFromCurrencyAndToCurrency(String formCurrency, String toCurrency);

}
