package com.gmail.fomenkoc.store.classes;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Mapper {

	public static Prod prod(ResultSet rs) throws SQLException {
		int prodID = rs.getInt("ProdID");
		String prodName = rs.getString("ProdName");
		String unitMeasurement = rs.getString("UM");
		return new Prod(prodID, prodName, unitMeasurement);
	}
	
	public static BarCode barCode(ResultSet rs) throws SQLException {
		int prodID = rs.getInt("ProdID");
		String barCode = rs.getString("BarCode");
		return new BarCode(prodID, barCode);
	}
	
	public static PriceList priceList(ResultSet rs) throws SQLException {
		int plid = rs.getInt("PLID");
		String plName = rs.getString("PLName");
		return new PriceList(plid, plName);
	}
	
	public static ProdPrice prodPrice(ResultSet rs) throws SQLException {
		int prodID = rs.getInt("ProdID");
		int plid = rs.getInt("PLID");
		double price = rs.getDouble("Price");
		return new ProdPrice(prodID, plid, price);
	}
	
	public static User user(ResultSet rs) throws SQLException {
		int userID = rs.getInt("UserID");
		String userName = rs.getString("UserName");
		boolean isAdmin = rs.getBoolean("IsAdmin");
		return new User(userID, userName, isAdmin);
	}
}
