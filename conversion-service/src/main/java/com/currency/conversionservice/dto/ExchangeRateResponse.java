package com.currency.conversionservice.dto;

import lombok.Data;

@Data
public class ExchangeRateResponse {
    private Long id;
    private String fromCurrency;
    private String toCurrency;
    private Double rate;
}