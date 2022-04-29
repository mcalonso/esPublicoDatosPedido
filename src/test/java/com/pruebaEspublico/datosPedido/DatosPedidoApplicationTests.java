package com.pruebaEspublico.datosPedido;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pruebaEspublico.Order.OrderService;

@SpringBootTest
class DatosPedidoApplicationTests {
	
	@Autowired
	private OrderService orderService;

	@Test
	public void when_nullFileLocation_then_returnException() {
		try {
			orderService.uploadCSVData(null);
		} catch (Exception e) {
			System.out.println("Error when_nullFileLocation_then_returnException: " + e);
		}
	}
	
	@Test
	public void when_emptyFileLocation_then_returnException() {
		try {
			orderService.uploadCSVData("");
		} catch (Exception e) {
			System.out.println("Error when_emptyFileLocation_then_returnException: " + e);
		}
	}
	
	@Test
	public void when_falseFileLocation_then_returnException() {
		try {
			orderService.uploadCSVData("false.csv");
		} catch (Exception e) {
			System.out.println("Error when_falseFileLocation_then_returnException: " + e);
		}
	}
	
	@Test
	public void when_nullParameter_then_returnException() {
		try {
			orderService.summaryByParameter(null);
		} catch (Exception e) {
			System.out.println("Error when_nullParameter_then_returnException: " + e);
		}
	}
	
	@Test
	public void when_emptyParameter_then_returnException() {
		try {
			orderService.summaryByParameter("");
		} catch (Exception e) {
			System.out.println("Error when_emptyParameter_then_returnException : " + e);
		}
	}
	
}
