package com.pruebaEspublico.Order;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class OrderController {

	private static final String UPLOAD_ERROR = "Error uploading file";
	
	@Autowired
	private OrderService orderService;
	
	public String treatmentCSVDocument(String csvPath) {
		try {
			return orderService.treatmentCSVDocument(csvPath);
		} catch (Exception e) {
			e.printStackTrace();
			return UPLOAD_ERROR;
		}
	}
	
	public Map<String, Map<String, String>> getOrderSummary() {
		try {
			return orderService.getOrderSummary();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
