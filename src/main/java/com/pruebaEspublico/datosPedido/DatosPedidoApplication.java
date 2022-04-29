package com.pruebaEspublico.datosPedido;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

import com.pruebaEspublico.Order.OrderController;



@SpringBootApplication
@ComponentScan(basePackages = {"com.pruebaEspublico"})
@EnableJdbcRepositories("com.pruebaEspublico")
public class DatosPedidoApplication implements CommandLineRunner {
	
	@Autowired
	private OrderController orderController;
	
	private static Logger LOG = LoggerFactory.getLogger(DatosPedidoApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(DatosPedidoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOG.info("Uploading order list...");
		String result = orderController.treatmentCSVDocument(args[0]);
		LOG.info(result);
		Map<String, Map<String, String>> summary = orderController.getOrderSummary();
		if(summary != null) {
			LOG.info("Summary of orders by params");
			summary.forEach((k,v)->{
				System.out.println("-------------------");
				System.out.println(k);
				System.out.println("-------------------");
				v.forEach((x,y)->{
					System.out.println(x + ":" + y);
		        });
			});	
		}
	}
}
