package com.pruebaEspublico.datosPedido;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("PEDIDOS")
public class Pedido {
	
	@Id
	private Integer id;
	private String region;
	private String country;
	private String itemType;
	private String salesChannel;
	private String orderPriority;
	private Date orderDate;
	private int orderID;
	private Date shipDate;
	private int unitsSold;
	private float unitPrice;
	private float unitCost;
	private float totalRevenue;
	private float totalCost;
	private float totalProfit;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public String getSalesChannel() {
		return salesChannel;
	}
	public void setSalesChannel(String salesChannel) {
		this.salesChannel = salesChannel;
	}
	public String getOrderPriority() {
		return orderPriority;
	}
	public void setOrderPriority(String orderPriority) {
		this.orderPriority = orderPriority;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public Date getShipDate() {
		return shipDate;
	}
	public void setShipDate(Date shipDate) {
		this.shipDate = shipDate;
	}
	public int getUnitsSold() {
		return unitsSold;
	}
	public void setUnitsSold(int unitsSold) {
		this.unitsSold = unitsSold;
	}
	public float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
	public float getUnitCost() {
		return unitCost;
	}
	public void setUnitCost(float unitCost) {
		this.unitCost = unitCost;
	}
	public float getTotalRevenue() {
		return totalRevenue;
	}
	public void setTotalRevenue(float totalRevenue) {
		this.totalRevenue = totalRevenue;
	}
	public float getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}
	public float getTotalProfit() {
		return totalProfit;
	}
	public void setTotalProfit(float totalProfit) {
		this.totalProfit = totalProfit;
	}
	
	@Override
	public String toString() {
		return "Pedido [id=" + id + ", region=" + region + ", country=" + country + ", itemType=" + itemType
				+ ", salesChannel=" + salesChannel + ", orderPriority=" + orderPriority + ", orderDate=" + orderDate
				+ ", orderID=" + orderID + ", shipDate=" + shipDate + ", unitsSold=" + unitsSold + ", unitPrice="
				+ unitPrice + ", unitCost=" + unitCost + ", totalRevenue=" + totalRevenue + ", totalCost=" + totalCost
				+ ", totalProfit=" + totalProfit + "]";
	}
}
