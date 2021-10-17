package com.capitol.Challenge;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
	
	private static final String FOUND_EXCEPTION = "The App found a exception when retrive SQL excecution";
	
	@BeforeEach
	void setUp() throws Exception {
		
	}

	@Test
	void test1() {
		
		priceRequest = new PriceRequest(LocalDateTime.parse("2020-06-14T10:00:00", formatter), 35455L, 1L);
		
		Price price = priceService.buscarRegistroPersonalizado(
				priceRequest.getDateConsulting(), priceRequest.getBrandId(), priceRequest.getProductId());
		
		assertNotNull(price, ROW_RECOVERY_OK);
		
		System.out.println("test1: " + price.toString());
		
	}

	@Test
	void test2() {
	
		priceRequest = new PriceRequest(LocalDateTime.parse("2020-06-14T16:00:00" , formatter), 35455L, 1L);
		
		Price price = priceService.buscarRegistroPersonalizado(
				priceRequest.getDateConsulting(), priceRequest.getBrandId(), priceRequest.getProductId());
		
		assertNotNull(price, ROW_RECOVERY_OK);
		
		System.out.println("test2: " + price.toString());
		
	}
	
	@Test
	void test3() {
	
		priceRequest = new PriceRequest(LocalDateTime.parse("2020-06-14T21:00:00" , formatter), 35455L, 1L);
		
		Price price = priceService.buscarRegistroPersonalizado(
				priceRequest.getDateConsulting(), priceRequest.getBrandId(), priceRequest.getProductId());
		
		assertNotNull(price, ROW_RECOVERY_OK);
		
		System.out.println("test3: " + price.toString());
		
	}
	
	@Test
	void test4() {
	
		priceRequest = new PriceRequest(LocalDateTime.parse("2020-06-15T10:00:00" , formatter), 35455L, 1L);
		
		Price price = priceService.buscarRegistroPersonalizado(
				priceRequest.getDateConsulting(), priceRequest.getBrandId(), priceRequest.getProductId());
		
		assertNotNull(price, ROW_RECOVERY_OK);
		
		System.out.println("test4: " + price.toString());
		
	}
	
	@Test
	void test5() {
	
		priceRequest = new PriceRequest(LocalDateTime.parse("2020-06-16T21:00:00" , formatter), 35455L, 1L);
		
		Price price = priceService.buscarRegistroPersonalizado(
				priceRequest.getDateConsulting(), priceRequest.getBrandId(), priceRequest.getProductId());
		
		assertNotNull(price, ROW_RECOVERY_OK);
		
		System.out.println("test5: " + price.toString());
		
	}
	
	@Test
	void test6() {
	
		List<Price> priceList = priceService.listar();
						
		assertNotNull(priceList, LIST_RECOVERY_OK);
		
		System.out.println("test6: " + priceList.toString());
		
	}
}
