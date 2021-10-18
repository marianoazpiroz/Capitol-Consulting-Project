package com.capitol.challenge.service;

import java.time.LocalDateTime;
import java.util.List;

import com.capitol.challenge.model.Price;

public interface IPriceService {
	
	public List<Price> getAll();
	
	public Price  searchPriceByProductBrandAndLocalDate(LocalDateTime date, Long productId, Long brandId);
	
}
