package com.gmail.fomenkoc.store.classes;

import java.sql.SQLException;

public class Prod {
	private int prodID;
	private String prodName;
	private String unitMeasurement;

	public Prod(int prodID, String prodName, String unitMeasurement) {
		super();
		this.prodID = prodID;
		this.prodName = prodName;
		this.unitMeasurement = unitMeasurement;
	}
	
	public Prod(String prodName, String unitMeasurement) {
		this.prodName = prodName;
		this.unitMeasurement = unitMeasurement;
	}
	
	public Prod(String prodName, String unitMeasurement, ProdDao dao)
														throws SQLException {
		this.prodID = dao.getNewProdID();
		this.prodName = prodName;
		this.unitMeasurement = unitMeasurement;
	}

	public int getProdID() {
		return prodID;
	}

	public void setProdID(int prodID) {
		this.prodID = prodID;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getUnitMeasurement() {
		return unitMeasurement;
	}

	public void setUnitMeasurement(String unitMeasurement) {
		this.unitMeasurement = unitMeasurement;
	}

	@Override
	public String toString() {
		return "Prod [prodID=" + prodID + ", prodName=" + prodName
				+ ", unitMeasurement=" + unitMeasurement + "]";
	}

}
