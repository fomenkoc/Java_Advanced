package com.gmail.fomenkoc;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Cart {
	private Integer id;
	private Double total;
	private String name;
	private Set<Item> items = new HashSet<Item>();

	public Cart() {
		super();
	}

	public Cart(Double total, String name) {
		super();
		this.total = total;
		this.name = name;
		
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, total);
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
		return Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(total, other.total);
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", total=" + total + ", name=" + name
				+ ", items=" + items + "]";
	}

}
