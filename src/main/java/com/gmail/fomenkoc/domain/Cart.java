package com.gmail.fomenkoc.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.gmail.fomenkoc.dao.impl.ProdDao;
import com.gmail.fomenkoc.dao.impl.UserDao;

@Entity
@Table(name = "cart")
public class Cart {
	@Id
	@Column(name = "cart_id")
	@GeneratedValue
	private Integer cartID;
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private User user;
	@ManyToOne
	@JoinColumn(name = "prod_id", referencedColumnName = "prod_id")
	private Prod prod;
	@Column(name = "price")
	private Double price;
	@Column(name = "quantity")
	private Double quantity;
	@Column(name = "sum")
	private Double sum;

	public Cart() {
		super();
	}
	
	public Cart(Integer userID, Integer prodID) {
		UserDao userDao = new UserDao();
		ProdDao prodDao = new ProdDao();
		User user = userDao.read(userID);
		Prod prod = prodDao.read(prodID);
		this.user = user;
		this.prod = prod;
		this.price = prod.getPrice();
		this.quantity = 1.0;
		this.sum = prod.getPrice();
	}

	public Cart(User user, Prod prod, Double price, Double quantity,
			Double sum) {
		super();
		this.user = user;
		this.prod = prod;
		this.price = price;
		this.quantity = quantity;
		this.sum = sum;
	}

	public Cart(Integer cartID, User user, Prod prod, Double price,
			Double quantity, Double sum) {
		super();
		this.cartID = cartID;
		this.user = user;
		this.prod = prod;
		this.price = price;
		this.quantity = quantity;
		this.sum = sum;
	}

	public Integer getCartID() {
		return cartID;
	}

	public void setCartID(Integer cartID) {
		this.cartID = cartID;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Prod getProd() {
		return prod;
	}

	public void setProd(Prod prod) {
		this.prod = prod;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Double getSum() {
		return sum;
	}

	public void setSum(Double sum) {
		this.sum = sum;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cartID, price, prod, quantity, sum, user);
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
				&& Objects.equals(prod, other.prod)
				&& Objects.equals(quantity, other.quantity)
				&& Objects.equals(sum, other.sum)
				&& Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Cart [cartID=" + cartID + ", user=" + user + ", prod=" + prod
				+ ", price=" + price + ", quantity=" + quantity + ", sum=" + sum
				+ "]";
	}

}
