package com.pruebaEspublico.Order;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {
	
	@Autowired
	public JdbcTemplate jdbctempl = new JdbcTemplate();
	
	public void save(Order order) {
		jdbctempl.update("INSERT INTO ORDERS VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
				order.getRegion(),
				order.getCountry(),
				order.getItemType(),
				order.getSalesChannel(),
				order.getOrderPriority(),
				order.getOrderDate(),
				order.getOrderID(),
				order.getShipDate(),
				order.getUnitsSold(),
				order.getUnitPrice(),
				order.getUnitCost(),
				order.getTotalRevenue(),
				order.getTotalCost(),
				order.getTotalProfit());
	}
	
	 public List<Map<String, Object>> findByParameter(String parameter) {
		 return jdbctempl.queryForList("SELECT " + parameter + ", count(*) as counter FROM ORDERS GROUP BY " + parameter);
	 }
}
