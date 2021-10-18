package com.capitol.Challenge;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.capitol.challenge.ChallengeApplication;
import com.capitol.challenge.model.Price;
import com.capitol.challenge.model.request.PriceRequest;
import com.capitol.challenge.service.PriceService;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ChallengeApplication.class)
@AutoConfigureTestDatabase
class PriceServiceTest {

	@Autowired
	private PriceService priceService;
	
	private PriceRequest priceRequest;
	
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern ( "yyyy-MM-dd'T'HH:mm:ss" );

	private static final String LIST_RECOVERY_OK = "The list of product has been recovery OK";
	
	private static final String ROW_RECOVERY_OK = "The ROW of price table  has been recovery OK";
	
	

	@ParameterizedTest
	@CsvSource ({"2020-06-14T10:00:00, 35.50", 
		"2020-06-14T16:00:00, 25.45",
		"2020-06-14T21:00:00, 35.50",
		"2020-06-15T10:00:00, 30.50",
		"2020-06-16T21:00:00, 38.95"})
	void test1(String date , Double expected ) {
		
		priceRequest = new PriceRequest(LocalDateTime.parse(date, formatter), 35455L, 1L);
		
		Price price = priceService.searchPriceByProductBrandAndLocalDate(
				priceRequest.getDateConsulting(), priceRequest.getProductId() ,priceRequest.getBrandId() );
		
		assertNotNull(price, ROW_RECOVERY_OK);
		assertEquals(expected, price.getPrice() );
		
	}


	
	@Test
	void test6() {
	
		List<Price> priceList = priceService.getAll();
						
		assertNotNull(priceList, LIST_RECOVERY_OK);
		assertEquals(4, priceList.size());
		
	}
}
