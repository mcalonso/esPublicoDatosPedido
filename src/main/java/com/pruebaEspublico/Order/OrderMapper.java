package com.pruebaEspublico.Order;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class OrderMapper implements RowMapper<Order> {

	@Override
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		Order order = new Order();
		
		order.setRegion(rs.getString("REGION"));
		order.setCountry(rs.getString("COUNTRY"));;
		order.setItemType(rs.getString("ITEM_TYPE"));;
		order.setSalesChannel(rs.getString("SALES_CHANNEL"));
		order.setOrderPriority(rs.getString("ORDER_PRIORITY"));
		order.setOrderDate(rs.getDate("ORDER_DATE"));
		order.setOrderID(rs.getInt("ORDER_ID"));
		order.setShipDate(rs.getDate("SHIP_DATE"));
		order.setUnitsSold(rs.getInt("UNITS_SOLD"));
		order.setUnitPrice(rs.getFloat("UNIT_PRICE"));
		order.setUnitCost(rs.getFloat("UNIT_COST"));
		order.setTotalRevenue(rs.getFloat("TOTAL_REVENUE"));
		order.setTotalCost(rs.getFloat("TOTAL_COST"));
		order.setTotalProfit(rs.getFloat("TOTAL_PROFIT"));
		
		return order;
	}

}
