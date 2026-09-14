package com.currency.conversionservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ConversionResponse {
    private String fromCurrency;
    private String toCurrency;
    private Double rate;
    private Double originalAmount;
    private Double convertedAmount;
}
