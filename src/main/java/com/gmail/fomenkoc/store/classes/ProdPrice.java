package com.gmail.fomenkoc.store.classes;

public class ProdPrice {
	private int prodID;
	private int plid;
	private double price;

	public ProdPrice(int prodID, int plid, double price) {
		super();
		this.prodID = prodID;
		this.plid = plid;
		this.price = price;
	}

	public int getProdID() {
		return prodID;
	}

	public void setProdID(int prodID) {
		this.prodID = prodID;
	}

	public int getPlid() {
		return plid;
	}

	public void setPlid(int plid) {
		this.plid = plid;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProdPrice [prodID=" + prodID + ", plid=" + plid + ", price="
				+ price + "]";
	}

}
