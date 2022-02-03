package com.gmail.fomenkoc;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Item {

	private Integer id;
	private Double total;
	private Set<Cart> carts = new HashSet<Cart>();

	public Item() {
		super();
	}

	public Item(Double total) {
		super();
		this.total = total;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Set<Cart> getCarts() {
		return carts;
	}

	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, total);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(id, other.id)
				&& Objects.equals(total, other.total);
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", total=" + total + ", carts=" + carts + "]";
	}

}
