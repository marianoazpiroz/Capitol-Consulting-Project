package com.capitol.challenge.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
	public List<Price> listar() {
		
		return priceDao.findAll();
	}

	@Override
	public Price buscarRegistroPersonalizado(LocalDateTime date,  Long productId, Long brandId) {
	
		return priceDao.buscarRegistroPersonalizado(date, productId, brandId);
	}



}
