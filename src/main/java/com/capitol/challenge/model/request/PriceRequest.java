package com.capitol.challenge.model.request;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PriceRequest {

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDate dateConsulting;
	private Long productId ;
	private Long brandId;
	
	public PriceRequest(LocalDate dateConsulting, Long productId, Long brandId) {
		super();
		this.dateConsulting = dateConsulting;
		this.productId = productId;
		this.brandId = brandId;
	}

	public LocalDate getDateConsulting() {
		return dateConsulting;
	}

	public void setDateConsulting(LocalDate dateConsulting) {
		this.dateConsulting = dateConsulting;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	
}
