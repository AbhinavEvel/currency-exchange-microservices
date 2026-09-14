package com.currency.exchangeservices.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "exchange_rate")
@Data 
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeRate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String fromCurrency;
	
	@Column(nullable = false)
	private String toCurrency;
	
	@Column(nullable = false)
	private Double rate;

}
