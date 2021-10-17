package com.capitol.challenge.service;

import java.time.LocalDate;
import java.util.List;

import com.capitol.challenge.model.Price;

public interface IPriceService {
	
	public List<Price> listar();
	
	public Price  buscarRegistroPersonalizado(LocalDate date, Long productId, Long brandId);
	
}
