package com.pruebaEspublico.DAOs;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pruebaEspublico.datosPedido.Pedido;

@Repository
public interface PedidoDAO extends CrudRepository<Pedido, Integer> {
		List<Pedido> findAll();
}
