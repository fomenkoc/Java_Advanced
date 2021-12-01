package com.gmail.fomenkoc.store.classes;

public class BarCode {

	private int prodID;
	private String barCode;

	public BarCode(int prodID, String barCode) {
		super();
		this.prodID = prodID;
		this.barCode = barCode;
	}

	public int getProdID() {
		return prodID;
	}

	public void setProdID(int prodID) {
		this.prodID = prodID;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	@Override
	public String toString() {
		return "BarCode [prodID=" + prodID + ", barCode=" + barCode + "]";
	}

}
