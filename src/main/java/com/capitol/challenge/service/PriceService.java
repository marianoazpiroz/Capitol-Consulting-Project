package com.capitol.challenge.service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capitol.challenge.model.Price;
import com.capitol.challenge.model.dao.IPrice;

@Service
public class PriceService implements IPriceService{

	@Autowired
	private IPrice priceDao;
	
	@Override
	public List<Price> getAll() {
		
		return priceDao.findAll();
	}

	@Override
	public Price searchPriceByProductBrandAndLocalDate(LocalDateTime date,  Long productId, Long brandId) {
	
		
		 List<Price> buscarRegistroPersonalizado = priceDao.searchPriceByProductBrandAndLocalDate(date, productId, brandId);
		 Price price = buscarRegistroPersonalizado.stream().max(Comparator.comparing(Price::getPriority)).get();
		 
		 return price;
	}



}
