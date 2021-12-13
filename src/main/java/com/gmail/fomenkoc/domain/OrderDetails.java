package com.gmail.fomenkoc.domain;

import java.util.Objects;

public class OrderDetails {

	private Integer orderDetID;
	private Integer orderID;
	private Integer prodID;
	private Double quantity;
	private Double price;

	public OrderDetails(Integer orderDetID, Integer orderID, Integer prodID,
			Double quantity, Double price) {
		super();
		this.orderDetID = orderDetID;
		this.orderID = orderID;
		this.prodID = prodID;
		this.quantity = quantity;
		this.price = price;
	}

	public OrderDetails(Integer orderID, Integer prodID, Double quantity,
			Double price) {
		super();
		this.orderID = orderID;
		this.prodID = prodID;
		this.quantity = quantity;
		this.price = price;
	}

	public Integer getOrderDetID() {
		return orderDetID;
	}

	public void setOrderDetID(Integer orderDetID) {
		this.orderDetID = orderDetID;
	}

	public Integer getOrderID() {
		return orderID;
	}

	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}

	public Integer getProdID() {
		return prodID;
	}

	public void setProdID(Integer prodID) {
		this.prodID = prodID;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderDetID, orderID, price, prodID, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDetails other = (OrderDetails) obj;
		return Objects.equals(orderDetID, other.orderDetID)
				&& Objects.equals(orderID, other.orderID)
				&& Objects.equals(price, other.price)
				&& Objects.equals(prodID, other.prodID)
				&& Objects.equals(quantity, other.quantity);
	}

	@Override
	public String toString() {
		return "OrderDetails [orderDetID=" + orderDetID + ", orderID=" + orderID
				+ ", prodID=" + prodID + ", quantity=" + quantity + ", price="
				+ price + "]";
	}

}
