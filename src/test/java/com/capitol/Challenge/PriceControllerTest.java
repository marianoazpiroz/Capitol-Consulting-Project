package com.capitol.Challenge;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.capitol.challenge.ChallengeApplication;
import com.capitol.challenge.controller.PriceController;
import com.capitol.challenge.model.Price;
import com.capitol.challenge.model.request.PriceRequest;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ChallengeApplication.class)
@AutoConfigureTestDatabase
class PriceControllerTest {

	@Autowired
	private PriceController priceController;
	
	private PriceRequest priceRequest;

	private static final String LIST_RECOVERY_OK = "The list of product has been recovery OK";
	
	private static final String ROW_RECOVERY_OK = "The ROW of price table  has been recovery OK";
	
	
	

	@Test
	void testListarJson() {
		
		ResponseEntity<List<Price>> priceList = priceController.listarJson();
		
		assertNotNull(priceList.getBody(), LIST_RECOVERY_OK);
		assertEquals(priceList.getBody().size(), 4);
		
	}

	@Test
	void testBuscarRegistroPersonalizado() {

		LocalDateTime odt = LocalDateTime.parse ( 
				"2020-06-14T21:00:00" , DateTimeFormatter.ofPattern ( "yyyy-MM-dd'T'HH:mm:ss" ) ) ;
		priceRequest = new PriceRequest(odt, 35455L, 1L);
		
		ResponseEntity<Price> priceRow = priceController.buscarRegistroPersonalizado(priceRequest);
		
		assertNotNull(priceRow.getBody(), ROW_RECOVERY_OK);
		assertEquals(priceRow.getStatusCode().is2xxSuccessful(), true);
		assertEquals(priceRow.getBody().getProduct_id(), 35455L);
		
		
	}

}
