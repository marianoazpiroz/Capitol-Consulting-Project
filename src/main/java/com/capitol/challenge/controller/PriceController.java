package com.capitol.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capitol.challenge.model.Price;
import com.capitol.challenge.model.request.PriceRequest;
import com.capitol.challenge.service.IPriceService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
public class PriceController {

	@Autowired
	private IPriceService priceService;

	@GetMapping("/getAll")
	public ResponseEntity<List<Price>> getAll() {

		return new ResponseEntity<List<Price>>(priceService.getAll(), HttpStatus.OK);	
	} 

	
	@RequestMapping(value ="/busqueda", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Price>  searchPriceByProductBrandAndLocalDate(@RequestBody PriceRequest priceRequest) {
		
		return new ResponseEntity<Price>(priceService.searchPriceByProductBrandAndLocalDate(priceRequest.getDateConsulting(), priceRequest.getProductId(), priceRequest.getBrandId()),HttpStatus.OK);
		
	}
	
	
}
