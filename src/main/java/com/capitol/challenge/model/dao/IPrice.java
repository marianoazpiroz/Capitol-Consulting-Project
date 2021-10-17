package com.capitol.challenge.model.dao;


import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capitol.challenge.model.Price;

public interface IPrice extends JpaRepository<Price, Long>{

	@Query("SELECT p FROM Price p WHERE :date BETWEEN START_DATE AND END_DATE AND :productId = PRODUCT_ID AND :brandId = BRAND_ID")
	public Price  buscarRegistroPersonalizado(@Param("date") LocalDateTime date, @Param("productId") Long productId, @Param("brandId") Long brandId);
	
}
