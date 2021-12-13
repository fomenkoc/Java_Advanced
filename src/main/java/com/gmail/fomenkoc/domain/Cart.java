package com.gmail.fomenkoc.domain;

import java.util.Objects;

public class Cart {
	private Integer cartID;
	private Integer userID;
	private Integer prodID;
	private Double price;

	public Cart(Integer cartID, Integer userID, Integer prodID, Double price) {
		super();
		this.cartID = cartID;
		this.userID = userID;
		this.prodID = prodID;
		this.price = price;
	}

	public Cart(Integer userID, Integer prodID, Double price) {
		super();
		this.userID = userID;
		this.prodID = prodID;
		this.price = price;
	}

	public Integer getCartID() {
		return cartID;
	}

	public void setCartID(Integer cartID) {
		this.cartID = cartID;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public Integer getProdID() {
		return prodID;
	}

	public void setProdID(Integer prodID) {
		this.prodID = prodID;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cartID, price, prodID, userID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		return Objects.equals(cartID, other.cartID)
				&& Objects.equals(price, other.price)
				&& Objects.equals(prodID, other.prodID)
				&& Objects.equals(userID, other.userID);
	}

	@Override
	public String toString() {
		return "Cart [cartID=" + cartID + ", userID=" + userID + ", prodID="
				+ prodID + ", price=" + price + "]";
	}

}
