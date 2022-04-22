package com.pruebaEspublico.datosPedido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.stereotype.Component;

import com.pruebaEspublico.DAOs.PedidoDAO;

@SpringBootApplication
@ComponentScan(basePackages = {"com.pruebaEspublico"})
@EnableJdbcRepositories("com.pruebaEspublico")
public class DatosPedidoApplication {
	
	@Autowired
	private PedidoDAO pedidoDAO;
	
	public static void main(String[] args) {
		SpringApplication.run(DatosPedidoApplication.class, args);
	}

	@EventListener({ApplicationReadyEvent.class})
	public void pruebaCrud() {
		//Test para comprobar la base de datos
		List<Pedido> pedidos = pedidoDAO.findAll();
		pedidos.forEach(System.out :: println);
		
	}

}
