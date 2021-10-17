package com.capitol.challenge.service;

import java.time.LocalDateTime;
import java.util.List;

import com.capitol.challenge.model.Price;

public interface IPriceService {
	
	public List<Price> listar();
	
	public Price  buscarRegistroPersonalizado(LocalDateTime date, Long productId, Long brandId);
	
}
